package com.adventofcode.day4;

import static com.adventofcode.day4.PassportData.PassportDataBuilder.aPassportData;
import static com.adventofcode.day4.PassportUtils.BLANK_STRING;

public class PassportData {
    private final int size;

    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    private PassportData(final int size) {
        this.size = size;
    }

    public static PassportData of(final String line) {
        final var passport = aPassportData();
        final var passportWordsDirty = line.split(BLANK_STRING);

        for (String dirtyWord : passportWordsDirty) {
            final var startIndex = dirtyWord.indexOf(':') + 1;
            if (dirtyWord.startsWith("ecl:")) {
                passport.withEcl(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("pid:")) {
                passport.withPid(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("eyr:")) {
                passport.withEyr(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("hcl:")) {
                passport.withHcl(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("byr:")) {
                passport.withByr(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("iyr:")) {
                passport.withIyr(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("cid:")) {
                passport.withCid(dirtyWord.substring(startIndex));
            } else if (dirtyWord.startsWith("hgt:")) {
                passport.withHgt(dirtyWord.substring(startIndex));
            }
        }

        return passport.build();
    }

    public String getByr() {
        return byr;
    }

    public String getIyr() {
        return iyr;
    }

    public String getEyr() {
        return eyr;
    }

    public String getHgt() {
        return hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public String getPid() {
        return pid;
    }

    public String getCid() {
        return cid;
    }

    public int getSize() {
        return size;
    }

    public static final class PassportDataBuilder {
        private int size;
        private String byr;
        private String iyr;
        private String eyr;
        private String hgt;
        private String hcl;
        private String ecl;
        private String pid;
        private String cid;

        private PassportDataBuilder() {
            this.size = 0;
        }

        public static PassportDataBuilder aPassportData() {
            return new PassportDataBuilder();
        }

        public PassportDataBuilder withByr(String byr) {
            this.byr = byr;
            this.size++;
            return this;
        }

        public PassportDataBuilder withIyr(String iyr) {
            this.iyr = iyr;
            this.size++;
            return this;
        }

        public PassportDataBuilder withEyr(String eyr) {
            this.eyr = eyr;
            this.size++;
            return this;
        }

        public PassportDataBuilder withHgt(String hgt) {
            this.hgt = hgt;
            this.size++;
            return this;
        }

        public PassportDataBuilder withHcl(String hcl) {
            this.hcl = hcl;
            this.size++;
            return this;
        }

        public PassportDataBuilder withEcl(String ecl) {
            this.ecl = ecl;
            this.size++;
            return this;
        }

        public PassportDataBuilder withPid(String pid) {
            this.pid = pid;
            this.size++;
            return this;
        }

        public PassportDataBuilder withCid(String cid) {
            this.cid = cid;
            this.size++;
            return this;
        }

        public PassportData build() {
            PassportData passportData = new PassportData(size);
            passportData.hcl = this.hcl;
            passportData.eyr = this.eyr;
            passportData.hgt = this.hgt;
            passportData.byr = this.byr;
            passportData.iyr = this.iyr;
            passportData.ecl = this.ecl;
            passportData.pid = this.pid;
            passportData.cid = this.cid;
            return passportData;
        }
    }
}
