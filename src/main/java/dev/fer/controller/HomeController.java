package dev.fer.controller;

import dev.fer.views.HomeView;

public class HomeController {

    public HomeController() {
        index();
    }
    
    public void index() {
        HomeView.printMenu();
    }

}