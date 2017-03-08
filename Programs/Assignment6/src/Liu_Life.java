/***************************************************************
 * file: Liu_Life.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 6
 * date last modified: 08 March 2017
 *
 * purpose: This program sets the basis for Conway's Game of Life. The class accepts the arguments for file and
 * iterations of generations to be made. it then uses the algo made and calculates if the cell should stay alive, die
 * or be made alive again. it then prints out the array for each individual generation to console for the user to see
 *
 ****************************************************************/
import java.io.*;
import java.util.*;

class Liu_Life{
	
	private int row;
	private int column;
	private int gen = 1;
	private char[][] originalLifeArray;
	private char[][] tempLifeArray;
	private final char LIFE = 'X';

	// method: Liu_Life
	// purpose: this method serves as the constructor for class Liu_Life. Takes in file input to read using object scanner
	// and then reads the chars from the file into an array, whilst creating a temporary array
	// @param  file  file to be read off of using object Scanner
 	// @param  iteration int amount to be inserted to computeNextGeneration(int) to calculate how many generations
 	// @see         Liu_Life
	public Liu_Life(File file, int iterations){
		try {
			String holder;

			Scanner input = new Scanner(file);

			String[] intHolder = input.nextLine().split("\\s+");

			column = Integer.parseInt(intHolder[0]);
			row = Integer.parseInt(intHolder[1]);

			originalLifeArray = new char[row][column];
			tempLifeArray = new char[row][column];

			for (int i = 0; i < row; i++) {
				holder = input.nextLine();
				holder = holder.replace(" ", "");
				char[] arrayCharHolder = holder.toCharArray();

				for (int j = 0; j < column; j++) {
						originalLifeArray[i][j] = arrayCharHolder[j];
				}
			}

			computeNextGeneration(iterations);

		} catch (FileNotFoundException e){
			System.out.println("File was not found, please try again");
		}
	}

	// method: getColumns
	// purpose: this method calculates how many columns are in originalLifeArray[] and returns
	// the length of said array
	// @param  row  which row to calculate how long the array is
	// @return      the length of said array
	private int getColumns(int row){
		return originalLifeArray[row].length;
	}

	// method: getRows
	// purpose: this method calculates how many rows are in originalLifeArray and returns
	// the length of said array
	// @return      the length of said array
	private int getRows(){
		return originalLifeArray.length;
	}

	// method: getCell
	// purpose: this method gets the char of the array
	// @param  column  the location of where the char is column wise
	// @param  row the location of where the char is row wise
	// @return      the char at the specified location in the array
	private char getCell(int column, int row){
		if (((originalLifeArray.length) < column) || ((originalLifeArray[row].length) < row)){
			System.err.print("Error, getCell out of bounds.\n");
			return '0';
		} else
			return originalLifeArray[row][column];
	}

	// method: setCell
	// purpose: this method sets the char value into the temporary array
	// @param  column  where column wise should the char be set
	// @param  row where row wise should the char be set
	// @param  value what value should be set in the array
	private void setCell(int column, int row, char value){
			tempLifeArray[row][column] = value;
	}

	// method: getAlive
	// purpose: this method calculates how many "cells" are alive in the relative location of where it is asked
	// each cell is check eight locations, left, right, up, down, diagonally left up and down, diagonally right up
	// and down
	// @param  column  what cell to check column wise
	// @param  row what cell to check row wise
	// @return      the amount of cells alive around the specified cell
	private int getAlive(int column, int row){
		//reset lifeCounter
		int lifeCounter = 0;

		//top left corner value
		if (column == 0 && row == 0){
			if (getCell(column+1, row) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, row) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, row+1) == LIFE)
				lifeCounter++;

			return lifeCounter;
			// top right corner
		} else if (column == getColumns(row)-1 && row == 0){
			if (getCell(getColumns(row)-2, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(0, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-2, 0) == LIFE)
				lifeCounter++;

			if (getCell(0, 0) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-2, row+1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(0, row+1) == LIFE)
				lifeCounter++;

			return lifeCounter;
			// bottom left corner
		} else if (column == 0 && row == getRows()-1){
			if (getCell(getColumns(row)-1, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column+1, row-1) == LIFE)
			lifeCounter++;

			if (getCell(getColumns(row)-1, row) == LIFE)
			lifeCounter++;

			if (getCell(column+1, row) == LIFE)
			lifeCounter++;

			if (getCell(getColumns(row)-1, 0) == LIFE)
			lifeCounter++;

			if (getCell(0, 0) == LIFE)
			lifeCounter++;

			if (getCell(column+1, 0) == LIFE)
			lifeCounter++;

			return lifeCounter;
			// bottom right corner
		} else if (column == getColumns(row)-1 && row == getRows()-1){
			if (getCell(column-1, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column, row-1) == LIFE)
			lifeCounter++;

			if (getCell(0, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column-1, row) == LIFE)
			lifeCounter++;

			if (getCell(0, row) == LIFE)
			lifeCounter++;

			if (getCell(column-1, 0) == LIFE)
			lifeCounter++;

			if (getCell(column, 0) == LIFE)
			lifeCounter++;

			if (getCell(0, 0) == LIFE)
			lifeCounter++;

			return lifeCounter;
			//left column
		} else if (column == 0 && row != 0 && row != getRows()-1){
			//compare last column
			if (getCell(getColumns(row)-1, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row-1) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, row) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row) == LIFE)
				lifeCounter++;

			if (getCell(getColumns(row)-1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row+1) == LIFE)
				lifeCounter++;

			return lifeCounter;
		} else if (column == getColumns(row)-1 && row != 0 && row != getRows()-1){
			//compare first column
			if (getCell(column-1, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column, row-1) == LIFE)
				lifeCounter++;

			if (getCell(0, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column-1, row) == LIFE)
				lifeCounter++;

			if (getCell(0, row) == LIFE)
				lifeCounter++;

			if (getCell(column-1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, row+1) == LIFE)
				lifeCounter++;

			if (getCell(0, row+1) == LIFE)
				lifeCounter++;

			return lifeCounter;
		} else if (column != 0 && column != getColumns(row)-1 && row == 0){
			if (getCell(column-1, row) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row) == LIFE)
				lifeCounter++;

			if (getCell(column-1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column-1, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(column, getRows()-1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, getRows()-1 ) == LIFE)
				lifeCounter++;

			return lifeCounter;
		} else if (column != 0 && column != getColumns(row)-1 && row == getRows()-1){
			if (getCell(column-1, 0) == LIFE)
			lifeCounter++;

			if (getCell(column, 0) == LIFE)
			lifeCounter++;

			if (getCell(column+1, 0) == LIFE)
			lifeCounter++;

			if (getCell(column-1, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column+1, row-1) == LIFE)
			lifeCounter++;

			if (getCell(column-1, row) == LIFE)
			lifeCounter++;

			if (getCell(column+1, row) == LIFE)
			lifeCounter++;

			return lifeCounter;
		} else {
			if (getCell(column-1, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row-1) == LIFE)
				lifeCounter++;

			if (getCell(column-1, row) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row) == LIFE)
				lifeCounter++;

			if (getCell(column-1, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column, row+1) == LIFE)
				lifeCounter++;

			if (getCell(column+1, row+1) == LIFE)
				lifeCounter++;

			return lifeCounter;
		}

	}
	
	// implement algo for Conway's Game of Life
	// every cell has 8 neighbours

	/*

	(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(0,6)
	(1,0)(1,1)(1,2)(1,3)(1,4)(1,5)(1,6)
	(2,0)(2,1)(2,2)(2,3)(2,4)(2,5)(2,6)
	(3,0)(3,1)(3,2)(3,3)(3,4)(3,5)(3,6)
	(4,0)(4,1)(4,2)(4,3)(4,4)(4,5)(4,6)
	(5,0)(5,1)(5,2)(5,3)(5,4)(5,5)(5,6)

	(5,6)|(5,0)(5,1)(5,2)(5,3)(5,4)(5,5)(5,6)|(5,0)
	----------------------------------------------
	(0,6)|(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(0,6)|(0,0)
	(1,6)|(1,0)(1,1)(1,2)(1,3)(1,4)(1,5)(1,6)|(1,0)
	(2,6)|(2,0)(2,1)(2,2)(2,3)(2,4)(2,5)(2,6)|(2,0)
	(3,6)|(3,0)(3,1)(3,2)(3,3)(3,4)(3,5)(3,6)|(3,0)
	(4,6)|(4,0)(4,1)(4,2)(4,3)(4,4)(4,5)(4,6)|(4,0)
	(5,6)|(5,0)(5,1)(5,2)(5,3)(5,4)(5,5)(5,6)|(5,0)
	----------------------------------------------
	(0,6)|(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(0,6)|(0,0)

	*/

	// implement recursive function
	// method: computeNextGeneration
	// purpose: this method compares the the next int generations for the array if the cell is alive and 2 or 3 are alive
	// then the cell stays alive, otherwise if there is less than 2 or more than three then the cell dies
	// otherwise if dead and there are three around it, then it becomes alive
	// @param  generation  how many generations to calculate
	private void computeNextGeneration(int generation){
		final char DEATH = '0';

		if (generation > 0) {
			System.out.println();
			System.out.printf("Generation %d%n%n", gen);
			gen++;
			print();
			for (int j = 0; j < getRows(); j++) {
				for (int k = 0; k < getColumns(j); k++) {
					if (getAlive(k, j) < 2 && (getCell(k, j) == LIFE)) {
						setCell(k, j, DEATH);
					} else if ((getAlive(k, j) == 2 || getAlive(k, j) == 3) && (getCell(k, j) == LIFE)){
						setCell(k, j, LIFE);
					} else if (getAlive(k, j) > 3 && (getCell(k, j) == LIFE)) {
						setCell(k, j, DEATH);
					} else if (getAlive(k, j) == 3 && getCell(k, j) == DEATH) {
						setCell(k, j, LIFE);
					} else {
						setCell(k, j, DEATH);
					}
				}
			}

			for (int l = 0; l < getRows(); l++){
				for (int m = 0; m < getColumns(l); m++){
					originalLifeArray[l][m] = tempLifeArray[l][m];
				}
			}

			computeNextGeneration(generation-1);
		}
	}


	// method: print
	// purpose: this method prints the array for originalLifeArray
	private void print(){
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				System.out.print(getCell(j, i));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}