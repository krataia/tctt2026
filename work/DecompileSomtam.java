import ghidra.app.decompiler.DecompInterface;
import ghidra.app.decompiler.DecompileResults;
import ghidra.app.script.GhidraScript;
import ghidra.program.model.listing.Function;
import java.util.List;

public class DecompileSomtam extends GhidraScript {
    @Override
    public void run() throws Exception {
        List<Function> matches = getGlobalFunctions(
            "Java_sh_sth_somtam_MainActivity_processPayload"
        );
        if (matches.size() != 1) {
            throw new IllegalStateException("target function not found");
        }
        Function function = matches.get(0);

        DecompInterface decompiler = new DecompInterface();
        decompiler.openProgram(currentProgram);
        DecompileResults results = decompiler.decompileFunction(function, 120, monitor);
        if (!results.decompileCompleted()) {
            throw new IllegalStateException(results.getErrorMessage());
        }
        println(results.getDecompiledFunction().getC());
        decompiler.dispose();
    }
}
