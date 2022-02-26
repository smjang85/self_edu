package com.testdome;

public class UserInput {

	public static class TextInput {
		protected String str = "";

		public void add(char c) {
			str = str + c;
		}

		public String getValue() {
			return str;
		}
	}

	public static class NumericInput extends TextInput {
		public void add(char c) {
			if (c >= '0' && c <= '9') {
				str = str + c;
			} else {

			}
		}
	}

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		System.out.println(input.getValue());
	}

}
