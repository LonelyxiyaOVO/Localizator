package localizator.data;

public class Production {
    // This variable is my main switch between Debug mode and Release (Production) mode.
    // In Debug mode, don't remap obfuscated methods. In Release mode, remap them.
    // In Debug mode, all mixins are enabled by default. In Production mode, they are disabled by default. 
    public static final boolean inProduction = true;
}
