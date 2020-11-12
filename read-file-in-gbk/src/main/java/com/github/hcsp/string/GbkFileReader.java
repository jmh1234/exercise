package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File("D:\\project\\VCUIntegToolGUI\\VCUIntegToolGUI\\resources\\app\\bin\\packFile");
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "FixedFile.txt")));
    }

    public String readFileWithGBK(File file) {
        try {
            if (file.exists()) {
                Long length = file.length();
                byte[] fileContent = new byte[length.intValue()];
                FileInputStream in = new FileInputStream(file);
                in.read(fileContent);
                return new String(fileContent, "GBK");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
