package com.example.designPattern;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    MvvmViewModel viewModel;

    @Before
    public void setUp() {
        if (viewModel == null)
            viewModel = new MvvmViewModel();
    }

    @Test
    public void getName() {
        viewModel.onClickBtnSave("a", "19970701");
        assertEquals(null, viewModel.getName().getValue());

        viewModel.onClickBtnLoad();
        assertEquals(null, viewModel.getName().getValue());

    }

    @Test
    public void getBirthday() {
    }
}