package design_pattern_edu.decorator_pattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import design_pattern_edu.decorator_pattern.inputstream.LowerCaseInputStream;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\workspaces\\edu_workspace\\design_pattern_edu\\src\\design_pattern_edu\\decorator_pattern\\test.txt")));
			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
