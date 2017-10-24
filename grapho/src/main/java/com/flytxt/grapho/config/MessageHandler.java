package com.flytxt.grapho.config;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.flytxt.grapho.exception.ApiError;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.exception.MessageType;

/**
 * @author shiju.john
 */
@ControllerAdvice
public class MessageHandler {

//	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

	@Autowired
	private MessageSource msgSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
		return processFieldError(error);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<Object> handleSQLException(HttpServletRequest request, SQLException ex) {
		return new ResponseEntity<Object>(new ApiError(MessageType.ERROR, getErrorMessage(ex.getLocalizedMessage()),
				null, HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(GraphoException.class)
	public ResponseEntity<Object> handleGraphoException(HttpServletRequest request, GraphoException ex) {
		return new ResponseEntity<Object>(new ApiError(MessageType.ERROR, getErrorMessage(ex.getLocalizedMessage()),
				ex.getFieldName(), HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * 
	 * @param error
	 * @return
	 */
	private ApiError processFieldError(FieldError error) {
		ApiError message = null;
		if (error != null) {
			message = new ApiError(MessageType.ERROR, getErrorMessage(error.getDefaultMessage()), error.getField(),
					HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	/**
	 * 
	 * @param messageCode
	 * @return
	 */
	private String getErrorMessage(String messageCode) {
		try {
			Locale currentLocale = LocaleContextHolder.getLocale();
			return msgSource.getMessage(messageCode, null, currentLocale);
		} catch (NoSuchMessageException exception) {
			return messageCode;
		}
	}
}