package com.gooddata.homework.services;

public interface CheckWord
{
    boolean isForbidden(String wordEntity);

    void refresh();
}
