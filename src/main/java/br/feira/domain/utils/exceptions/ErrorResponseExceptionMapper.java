package br.feira.domain.utils.exceptions;

import java.time.LocalDateTime;

import br.feira.domain.entities.enums.EnumErrorCode;
import br.feira.domain.utils.DateUtil;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ErrorResponseExceptionMapper implements ExceptionMapper<FeiraException> {

    @Override
    public Response toResponse(FeiraException ex) {

        int BAD_REQUEST = 400;
        int httpStatus;
        var error = EnumErrorCode.parseByKey(ex.getErrorCode());

        var formattedDate = DateUtil.formatDDMMYYYYHHMMSS(LocalDateTime.now());
        var exceptionResponse = new FeiraExceptionResponseDTO();

        exceptionResponse.setError(ex.getMessage());
        exceptionResponse.setErrorDate(formattedDate);

        if (error != null) {
            var errorPhrase = Status.fromStatusCode(error.getHttpStatus()).getReasonPhrase();
            httpStatus = error.getHttpStatus();

            exceptionResponse.setErrorCode(error.getKey());
            exceptionResponse.setHttpCodeMessage(errorPhrase);
        } else {
            exceptionResponse.setErrorCode(ex.getErrorCode());
            httpStatus = BAD_REQUEST;
        }

        return Response.status(httpStatus).entity(exceptionResponse).build();
    }

}
