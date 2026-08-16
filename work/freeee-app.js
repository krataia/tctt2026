// Console front-end: keeps the numbers on the page fresh without a reload.
(function () {
  "use strict";

  function fmtBytes(n) {
    if (n < 1024) return n + " B";
    if (n < 1024 * 1024) return (n / 1024).toFixed(1) + " KB";
    return (n / 1048576).toFixed(1) + " MB";
  }

  // The v1 SDK addresses resources with the format in the path; the console
  // front-end kept the convention so both speak to the same URLs.
  function usage() {
    var slot = document.querySelector("[data-usage]");
    if (!slot) return;
    fetch("/console/api/usage.json", { credentials: "same-origin" })
      .then(function (r) { return r.ok ? r.json() : null; })
      .then(function (d) {
        if (!d) return;
        slot.textContent = d.keys + " keys · " + fmtBytes(d.bytes_used) +
          " of " + fmtBytes(d.bytes_quota);
      })
      .catch(function () { /* the console still renders without it */ });
  }

  document.addEventListener("DOMContentLoaded", usage);
})();
