package com.example.demo;


import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public final class FooBarHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(FooBar.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String bar = webRequest.getParameter("bar");
        String foo = webRequest.getParameter("foo");

        //값이 없는 경우 기본값을 할당해주었는데, 시험문제에서는 없으면 없는대로, 생성하면 되도록함
        if(bar == null){
            bar = "defaultBar";
        }
        if(foo == null){
            foo = "defaultFoo";
        }

        return new FooBar(bar, foo);
    }
}
