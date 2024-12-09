package fr.eni.tpLudotheque.exceptions;

import org.springframework.dao.DuplicateKeyException;

public class CodeBarreDejaExistantException extends Exception{

	public CodeBarreDejaExistantException(DuplicateKeyException duplicateKeyException) {
		// TODO Auto-generated constructor stub
	}

}
