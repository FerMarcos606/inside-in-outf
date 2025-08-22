package dev.fer.controller;

import dev.fer.views.HomeView;

public class HomeController {
    
    private final HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
    }
    
    public void index() {
        this.view.printMenu();
    }
}