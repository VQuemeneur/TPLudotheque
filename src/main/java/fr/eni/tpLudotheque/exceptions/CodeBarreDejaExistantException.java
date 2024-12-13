package fr.eni.tpLudotheque.exceptions;

import org.springframework.dao.DuplicateKeyException;

public class CodeBarreDejaExistantException extends Exception {

	public CodeBarreDejaExistantException() {
		super();

	}

	public CodeBarreDejaExistantException(DuplicateKeyException duplicateKeyException) {

	}

}
