package com.craftinginterpreters.lox;

import static com.craftinginterpreters.lox.TokenType.*;

class Token {
	final TokenType type;
	final String lexeme;
	final Object literal;
	final int line;

	Token(TokenType type, String lexeme, Object literal, int line) {
		this.type = type;
		this.lexeme = lexeme;
		this.literal = literal;
		this.line = line;
	}

	public String toString() {
		if (match(NUMBER, EOF, PLUS, MINUS, SLASH, STAR, EQUAL, COMMA, STRING)) {
			return "\033[33m" + type + "\t\t\033[34m" + lexeme + "\t\033[36m" + literal + "\033[m";	
		}
		return "\033[33m" + type + "\t\033[34m" + lexeme + "\t\033[36m" + literal + "\033[m"; 
	}

	private boolean match(TokenType... types) {
		for (TokenType type : types) {
			if (type == this.type) {
				return true;
			}
		}
		return false;
	}
}
