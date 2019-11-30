/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.SpanGame;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;
// I made a lot of alterations to the controller.  I essentially made a separate method for all of the game actions for the Spanish 
// version of the game.
@Singleton
public class ApplicationController {
    boolean spanishGame = false;
    public Result index() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }
    
    // This function is called if the user clicks on the regular game button
    public Result gameGet(){
        Game g = new Game();
        g.shuffle();
        g.dealFour();

        return Results.json().render(g);
    }
    
    // This function is called if the user clicks on the Spanish game button
    public Result sgameGet() {
        SpanGame g1 = new SpanGame();
        g1.shuffle();
        g1.dealFour();

        return Results.json().render(g1);
    }
    
    public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        return Results.json().render(g);
    }
    
    public Result sdealPost(Context context, SpanGame g1) {
        if (context.getRequestPath().contains("deal")) {
            g1.dealFour();
        }
        return Results.json().render(g1);
    }

    public Result removeCard(Context context, @PathParam("column") int colNumber, Game g){
        g.remove(colNumber);
        return Results.json().render(g);
    }
    
    public Result sremoveCard(Context context, @PathParam("column") int colNumber, SpanGame g1) {
        g1.remove(colNumber);
        return Results.json().render(g1);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game g){
        g.move(colFrom,colTo);
        return Results.json().render(g);
    }
    
    public Result smoveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo,
            SpanGame g1) {
        g1.move(colFrom, colTo);
        return Results.json().render(g1);
    }
    
    public Result endGame() { return Results.html().template("views/exitPage/endGame.html"); }


}
