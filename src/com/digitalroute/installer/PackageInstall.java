package com.digitalroute.installer;

public class PackageInstall extends Install {

    @Override
    protected String getConfigName() {
        return "lojic";
    }

    public static void main(final String[] args) {
        System.exit(new PackageInstall().parse(args));
    }
}
