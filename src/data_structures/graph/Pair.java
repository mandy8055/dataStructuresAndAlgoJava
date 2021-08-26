package data_structures.graph;

import org.jetbrains.annotations.NotNull;

public class Pair implements Comparable<Pair> {
    int wsf;
    String psf;

    Pair(int wsf, String psf) {
        this.wsf = wsf;
        this.psf = psf;
    }

    public int compareTo(@NotNull Pair o) {
        return this.wsf - o.wsf;
    }
}
