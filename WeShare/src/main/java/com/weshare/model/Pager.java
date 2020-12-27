package com.weshare.model;

public class Pager {
    private int numOfButtons = 5;
    private int firstButton;
    private int finalButton;

    public Pager(int totalPages, int currentPage, int numOfButtons) {

        setNumOfButtons(numOfButtons);

        int halfPagesToShow = getNumOfButtons() / 2;

        if (totalPages <= getNumOfButtons()) {
            setFirstButton(1);
            setFinalButton(totalPages);

        } else if (currentPage - halfPagesToShow <= 0) {
            setFirstButton(1);
            setFinalButton(getNumOfButtons());

        } else if (currentPage + halfPagesToShow == totalPages) {
            setFirstButton(currentPage - halfPagesToShow);
            setFinalButton(totalPages);

        } else if (currentPage + halfPagesToShow > totalPages) {
            setFirstButton(totalPages - getNumOfButtons() + 1);
            setFinalButton(totalPages);

        } else {
            setFirstButton(currentPage - halfPagesToShow);
            setFinalButton(currentPage + halfPagesToShow);
        }

    }

    public void setNumOfButtons(int numOfButtons) {
        if(numOfButtons % 2 != 0) {
            this.numOfButtons = numOfButtons;
        } else {
            throw new IllegalArgumentException("Make sure you type in an odd value");
        }
    }

    public int getNumOfButtons() {
        return numOfButtons;
    }

    public int getFirstButton() {
        return firstButton;
    }

    public void setFirstButton(int firstButton) {
        this.firstButton = firstButton;
    }

    public int getFinalButton() {
        return finalButton;
    }

    public void setFinalButton(int finalButton) {
        this.finalButton = finalButton;
    }

    @Override
    public String toString() {
        return "Pager [firstButton=" + firstButton + ", finalButton=" + finalButton + "]";
    }
}

