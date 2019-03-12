package com.example.www.lainxi.bean;

public class Result {
    private Mlss mlss;
    private Pzsh pzsh;
    private Rxxp rxxp;

    public Mlss getMlss() {
        return mlss;
    }

    public void setMlss(Mlss mlss) {
        this.mlss = mlss;
    }

    public Pzsh getPzsh() {
        return pzsh;
    }

    public void setPzsh(Pzsh pzsh) {
        this.pzsh = pzsh;
    }

    public Rxxp getRxxp() {
        return rxxp;
    }

    public void setRxxp(Rxxp rxxp) {
        this.rxxp = rxxp;
    }

    @Override
    public String toString() {
        return "Result{" +
                "mlss=" + mlss +
                ", pzsh=" + pzsh +
                ", rxxp=" + rxxp +
                '}';
    }

}
