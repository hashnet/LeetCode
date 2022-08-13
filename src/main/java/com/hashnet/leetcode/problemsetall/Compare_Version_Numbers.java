package com.hashnet.leetcode.problemsetall;

class Compare_Version_Numbers {
    public static void main(String[] args) {
        String version1 = "1.00000000000000000000001";
        String version2 = "1.10";

        Compare_Version_Numbers s = new Compare_Version_Numbers();
        System.out.println(s.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        version1 = version1.replaceAll("\\.", "");
        version2 = version2.replaceAll("\\.", "");

        return new Long(version1).compareTo(new Long(version2));
    }
}