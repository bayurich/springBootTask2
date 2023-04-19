package ru.netology.springbootrest.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.springbootrest.exception.InvalidCredentials;
import ru.netology.springbootrest.model.User;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //TODO ??? не находит аннотацию UserResolve у параметра user, нужно разбираться
        return parameter.hasParameterAnnotation(UserResolve.class) /*&&
                parameter.getParameterType().equals(User.class)*/;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String user = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");

        if (user == null || user.length() < 5 || user.length() > 10) {
            throw new InvalidCredentials("User name has incorrect length");
        }
        if (password == null || password.length() < 8 || password.length() > 20) {
            throw new InvalidCredentials("User password has incorrect length");
        }

        return new User(user, password);
    }
}
