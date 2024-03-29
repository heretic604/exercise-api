package by.heretic.exercise.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

import static by.heretic.exercise.util.Constants.REQUEST;
import static by.heretic.exercise.util.Constants.RESPONSE;
import static org.apache.commons.lang3.StringUtils.SPACE;

@Slf4j
@Component
public class HttpMessageLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest httpRequest,
                                    @NotNull HttpServletResponse httpResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        var request = new ContentCachingRequestWrapper(httpRequest);
        var response = new ContentCachingResponseWrapper(httpResponse);

        log.info(requestLogMessage(request));
        filterChain.doFilter(request, response);
        log.info(responseLogMessage(response));

        response.copyBodyToResponse();
    }

    private String requestLogMessage(ContentCachingRequestWrapper request) {
        return REQUEST + request.getMethod() + SPACE + request.getRequestURL();
    }

    private String responseLogMessage(ContentCachingResponseWrapper response) {
        return RESPONSE + response.getStatus();
    }

}