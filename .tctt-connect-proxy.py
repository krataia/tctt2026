#!/usr/bin/env python3
import select
import socket
import sys
import threading


ALLOWED_HOST = "shop.cybertop2026.site"


def relay(client, upstream):
    sockets = (client, upstream)
    while True:
        readable, _, _ = select.select(sockets, (), (), 30)
        if not readable:
            continue
        for source in readable:
            data = source.recv(65536)
            if not data:
                return
            destination = upstream if source is client else client
            destination.sendall(data)


def handle(client, upstream_ip):
    upstream = None
    try:
        request = b""
        while b"\r\n\r\n" not in request and len(request) < 16384:
            chunk = client.recv(4096)
            if not chunk:
                return
            request += chunk
        first_line = request.split(b"\r\n", 1)[0].decode("ascii", "replace")
        parts = first_line.split()
        if len(parts) != 3 or parts[0] != "CONNECT":
            client.sendall(b"HTTP/1.1 405 Method Not Allowed\r\nConnection: close\r\n\r\n")
            return
        authority = parts[1].rsplit(":", 1)
        if len(authority) != 2 or authority[0].lower() != ALLOWED_HOST or authority[1] != "443":
            client.sendall(b"HTTP/1.1 403 Forbidden\r\nConnection: close\r\n\r\n")
            return
        upstream = socket.create_connection((upstream_ip, 443), timeout=10)
        client.sendall(b"HTTP/1.1 200 Connection Established\r\n\r\n")
        relay(client, upstream)
    except (ConnectionError, OSError):
        pass
    finally:
        if upstream is not None:
            upstream.close()
        client.close()


def main():
    listen_port = int(sys.argv[1])
    upstream_ip = sys.argv[2]
    listener = socket.create_server(("127.0.0.1", listen_port), reuse_port=False)
    listener.listen(32)
    print(f"ready 127.0.0.1:{listen_port} -> {upstream_ip}:443", flush=True)
    while True:
        client, _ = listener.accept()
        threading.Thread(target=handle, args=(client, upstream_ip), daemon=True).start()


if __name__ == "__main__":
    main()
