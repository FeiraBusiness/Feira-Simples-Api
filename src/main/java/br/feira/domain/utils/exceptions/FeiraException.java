package br.feira.domain.utils.exceptions;

import br.feira.domain.entities.enums.EnumErrorCode;
import br.feira.domain.utils.StringUtil;

public class FeiraException extends RuntimeException {

    private String errorCode = "-1";

    public FeiraException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FeiraException(EnumErrorCode error) {
        super(error.getErro());
        this.errorCode = error.getKey();
    }

    public FeiraException(EnumErrorCode error, Object... args) {
        super(StringUtil.stringPatternFormat(error.getErro(), args));
        this.errorCode = error.getKey();
    }

    public String getErrorCode() {
        return errorCode;
    }

}
