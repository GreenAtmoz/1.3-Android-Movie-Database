package com.example.movieapp.DataStorrage;

import com.example.movieapp.Domain.MovieElements;
import java.util.ArrayList;

public interface AsyncResponse {
    void processFinish(ArrayList<MovieElements> output);
    void processStringFinish(String output);
    void processArrayStringsFinish(ArrayList<Review> output);
}
