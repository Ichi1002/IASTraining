package com.co.ias.commons;

public interface UseCase<Input,Output> {

    Output execute(Input input);
}
