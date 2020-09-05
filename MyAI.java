package team11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import game.AI;
import game.Board;
import game.Board.ControlKeys;
import game.Shape;
import game.Shape.Tetrominoes;
import java.io.FileReader;
import java.util.Scanner;

import game.AI;
import game.Board;
import game.Board.ControlKeys;
import game.Shape;
import game.Shape.Tetrominoes;

public class MyAI extends AI {
	
	// default constructor must be public
	public MyAI() {
		super();
		String filepath = "/Users/JC/Documents/workspace/TermProject/src/team11/dummy.txt";
		try {
			Scanner in = new Scanner(new FileReader(filepath));
			while (in.hasNext()) {
				System.out.println(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	};
	
	int rightEmpty(int y) {		
		for (int x=Board.WIDTH; x-->0;) {
			if (shapeAt(x, y) == Tetrominoes.EMPTY) return x;
		}
		return -1;
	}	
	
	int leftEmpty(int y) {
		for (int x=0; x<Board.WIDTH; x++) {
			if (shapeAt(x, y) == Tetrominoes.EMPTY) return x;
		}
		return Board.WIDTH;
	}
	boolean isThereConsecutiveLeftEmpty(int y, int n){
		int startPoint = leftEmpty(y);
		boolean answer = false;
		int consecutiveNum = 0;
		if(leftEmpty(y)!=-1 && (leftEmpty(y)+n-1<Board.WIDTH)){
			for(int a = leftEmpty(y); a<Board.WIDTH; a++ ){
				if(shapeAt(a,y)!=Tetrominoes.EMPTY) {
					if(consecutiveNum>=n){
						for(int x = startPoint; x<startPoint+n; x++){
							if(topPoint(x)!=topPoint(startPoint)){
								startPoint = a+1;
								consecutiveNum=0;
								answer = false;
								break;
							}else answer = true;
						}
						if(answer)	break;
						else continue;
					}else{
						startPoint = a+1;
						consecutiveNum=0;
						continue;
					}
				}
				else { 
					if(consecutiveNum<n) {
						if(topPoint(a)==y) consecutiveNum+=1;
						else {
							startPoint = a+1;
							consecutiveNum=0;
							continue;
						}
					} if(consecutiveNum==n){
						for(int x = startPoint; x<startPoint+n; x++){
							if(topPoint(x)!=topPoint(startPoint)){
								startPoint = a+1;
								consecutiveNum=0;
								answer = false;
								break;
							}else answer = true;
						}
						if(answer)	break;
						else if (!answer) continue;
					}
				}
			}
		}else answer = false;
		return answer;
	}
	
	int consecutiveLeftEmpty(int y, int n){
		int startPoint = leftEmpty(y);
		boolean answer = false;
		if(isThereConsecutiveLeftEmpty(y, n)){
			int consecutiveNum = 0;
				for(int a = leftEmpty(y); a<Board.WIDTH; a++ ){
					if(shapeAt(a,y)!=Tetrominoes.EMPTY) {
						if(consecutiveNum>=n){
							for(int x = startPoint; x<startPoint+n; x++){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a+1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else continue;
						}else{
							startPoint = a+1;
							consecutiveNum=0;
							continue;
						}
					}
					else { 
						if(consecutiveNum<n) {
							if(topPoint(a)==y) consecutiveNum+=1;
							else {
								startPoint = a+1;
								consecutiveNum=0;
								continue;
							}
						} if(consecutiveNum==n){
							for(int x = startPoint; x<startPoint+n; x++){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a+1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else if (!answer) continue;
						}
					}
				}
	
		}
		return startPoint;
	}
	
	boolean isThereConsecutiveRightEmpty(int y, int n){
		int startPoint = rightEmpty(y);
		boolean answer = false;
		int consecutiveNum = 0;
		if(rightEmpty(y)!=-1&&(rightEmpty(y)-n+1>=0)){
			for(int a = rightEmpty(y); a>=0; a-- ){
				if(shapeAt(a,y)!=Tetrominoes.EMPTY) {
					if(consecutiveNum>=n){
							for(int x = startPoint; x>startPoint-n; x--){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a-1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else continue;
						}else{
							startPoint = a-1;
							consecutiveNum=0;
							continue;
						}
					}
					else { 
						if(consecutiveNum<n) {
							if(topPoint(a)==y) consecutiveNum+=1;
							else {
								startPoint = a-1;
								consecutiveNum=0;
								continue;
							}
						} if(consecutiveNum==n){
							for(int x = startPoint; x>startPoint-n; x--){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a-1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else if (!answer) continue;
						}
					}
				}
			}else answer = false;
		return answer;
	}
	
	int consecutiveRightEmpty(int y, int n){
		int startPoint = rightEmpty(y);
		boolean answer = false;
		if(isThereConsecutiveRightEmpty(y, n)){
			int consecutiveNum = 0;
				for(int a = rightEmpty(y); a>=0; a-- ){
					if(shapeAt(a,y)!=Tetrominoes.EMPTY) {
						if(consecutiveNum>=n){
							for(int x = startPoint; x>startPoint-n; x--){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a-1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else continue;
						}else{
							startPoint = a-1;
							consecutiveNum=0;
							continue;
						}
					}
					else { 
						if(consecutiveNum<n) {
							if(topPoint(a)==y) consecutiveNum+=1;
							else {
								startPoint = a-1;
								consecutiveNum=0;
								continue;
							}
						} if(consecutiveNum==n){
							for(int x = startPoint; x>startPoint-n; x--){
								if(topPoint(x)!=topPoint(startPoint)){
									startPoint = a-1;
									consecutiveNum=0;
									answer = false;
									break;
								}else answer = true;
							}
							if(answer)	break;
							else if (!answer) continue;
						}
					}
				}
		
		}
		return startPoint;
	}
	
	int topPoint(int x){
		for (int y=Board.HEIGHT-1; y-->0;) {
			if (shapeAt(x, y) != Tetrominoes.EMPTY) {
				return y+1;
			}
		}
		return 0;
	}
	
	int maxTopX(){
		int max = 0;
		int b = 0;
		for(b = 0; b<Board.WIDTH; b++) {
			if(topPoint(b)>=topPoint(max))	max = b;
		}
		return max;
	}
	
	int minTopX(){
		int min = 0;
		int c = 0;
		for(c = 0; c<Board.WIDTH; c++) {
			if(topPoint(c)<=topPoint(min))	min = c;
		}
		return min;
	}
	

	
	boolean boardIsEmpty(){
		boolean answer = true;
		for(int i=0; i<10; i++){
			if(topPoint(i)!=0){
				answer = false;
				break;
			}
		}
		return answer;
	}
	

	@Override
	protected ControlKeys command() {
		ControlKeys key = ControlKeys.SPACE;
		Shape curPiece = getCurPiece();
		int err1 = 0;
		
		if(boardIsEmpty()){
			if((curPiece.getShape()==Tetrominoes.ZSHAPE)||(curPiece.getShape()==Tetrominoes.SSHAPE)){	//OK
				key = ControlKeys.DEL;}
			if(curPiece.getShape() ==Tetrominoes.ISHAPE){	//OK
				if(curPiece.x(0)!=1) key = ControlKeys.UP;
				else if (getCurX()>2) key = ControlKeys.LEFT;	}
			if(curPiece.getShape() == Tetrominoes.TSHAPE){	//OK
				if(curPiece.x(0)!=1) key = ControlKeys.DOWN;
				else if (getCurX()<8) key = ControlKeys.RIGHT;	}
			if(curPiece.getShape() == Tetrominoes.SQUARE){	//OK
				if (getCurX()>0) key = ControlKeys.LEFT;	}
			if(curPiece.getShape() == Tetrominoes.LSHAPE){	//OK
				if(curPiece.x(0)!=1) key = ControlKeys.DOWN;
				else if (getCurX()<Board.WIDTH-2) key = ControlKeys.RIGHT;	}
			if(curPiece.getShape() == Tetrominoes.JSHAPE){	//OK
				if(curPiece.x(0)!=-1) key = ControlKeys.UP;
				else if (getCurX()>1) key = ControlKeys.LEFT;	}
		}
		
		for(int i = 1; i<Board.WIDTH-1; i++){
			if ((shapeAt(i, 13) != Tetrominoes.EMPTY)){
				if((topPoint(maxTopX())>13||!(Math.abs(topPoint(1)-topPoint(0))<3||Math.abs(topPoint(8)-topPoint(9))<3))&&curPiece.getShape()!=Tetrominoes.ISHAPE) {key = ControlKeys.DEL;
				break;
				}
			}
			else if(topPoint(i+1)-topPoint(i)>5&&topPoint(i-1)-topPoint(i)>5&topPoint(maxTopX())>10){
				if(curPiece.getShape()!=Tetrominoes.ISHAPE) key = ControlKeys.DEL;
				break;
			}
		}
		
		if((topPoint(1)-topPoint(0)>5&&topPoint(8)-topPoint(9)>5)){
			if(curPiece.getShape()!=Tetrominoes.ISHAPE) key = ControlKeys.DEL;
		}else if(((maxTopX()>1)&&(maxTopX()<8)&&(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()-1))==1&&(topPoint(maxTopX()-1)-topPoint(maxTopX()-2))>5)||(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()+1))==1&&topPoint(maxTopX()+1)-topPoint(maxTopX()+2)>5))&&topPoint(maxTopX())>11&&!(Math.abs(topPoint(1)-topPoint(0))<3||Math.abs(topPoint(8)-topPoint(9))<3)){
			if(curPiece.getShape()!=Tetrominoes.ISHAPE) key = ControlKeys.DEL;
		}else if(((maxTopX()>1)&&(maxTopX()<8)&&(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()-1))==2&&(topPoint(maxTopX()-1)-topPoint(maxTopX()-2))>5)||(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()+1))==2&&topPoint(maxTopX()+1)-topPoint(maxTopX()+2)>5))&&topPoint(maxTopX())>11&&!(Math.abs(topPoint(1)-topPoint(0))<3||Math.abs(topPoint(8)-topPoint(9))<3)){
			if(curPiece.getShape()!=Tetrominoes.ISHAPE) key = ControlKeys.DEL;
		}else if(((maxTopX()>1)&&(maxTopX()<8)&&(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()-1))==0&&(topPoint(maxTopX()-1)-topPoint(maxTopX()-2))>5)||(Math.abs(topPoint(maxTopX())-topPoint(maxTopX()+1))==0&&topPoint(maxTopX()+1)-topPoint(maxTopX()+2)>5))&&topPoint(maxTopX())>11&&!(Math.abs(topPoint(1)-topPoint(0))<3||Math.abs(topPoint(8)-topPoint(9))<3)){
			if(curPiece.getShape()!=Tetrominoes.ISHAPE) key = ControlKeys.DEL;
		}
		
		if(curPiece.getShape()==Tetrominoes.ISHAPE){
			int targetI =0;
			boolean answerI = false;
			boolean steepI = false;
			int targetSteep = 0;
			
			for (int a = 0; a<= topPoint(maxTopX()); a++){
				answerI = isThereConsecutiveRightEmpty(a,4)||isThereConsecutiveLeftEmpty(a,4);
				if(answerI==true) {
					targetI = a;
					break;
				}
			} 
			
			for(int i = 1; i<Board.WIDTH-1; i++){
				steepI = (topPoint(i+1)-topPoint(i)>=3)&&(topPoint(i-1)-topPoint(i)>=3);
				if(steepI){
					targetSteep = i;
					break;
				}
			}
			
			
			if(answerI==false){
				if(steepI&&topPoint(targetSteep)<4){
					if(targetSteep<getCurX()) key = ControlKeys.LEFT;
					else if (targetSteep>getCurX()) key = ControlKeys.RIGHT;
				}else if(minTopX()<getCurX()) key = ControlKeys.LEFT;
				else if (minTopX()>getCurX()) key = ControlKeys.RIGHT;	
			}
			else if(answerI==true) {
				if(steepI==false){
					if(!(topPoint(1)>=2+topPoint(0)||topPoint(8)>=2+topPoint(9))){
						if(curPiece.x(0)!=1) key = ControlKeys.UP;
							else if(isThereConsecutiveLeftEmpty(targetI,4)) {
								if(consecutiveLeftEmpty(targetI,4)+2<getCurX()) key = ControlKeys.LEFT;
								else if(consecutiveLeftEmpty(targetI,4)+2>getCurX()) key = ControlKeys.RIGHT;
							}else if(isThereConsecutiveRightEmpty(targetI,4)) {
								if(consecutiveRightEmpty(targetI,4)-1>getCurX()) key = ControlKeys.RIGHT;
								else if(consecutiveRightEmpty(targetI,4)-1<getCurX()) key = ControlKeys.LEFT;
							}
					}
					else if(minTopX()<getCurX()) key = ControlKeys.LEFT;
					else if (minTopX()>getCurX()) key = ControlKeys.RIGHT;	
					
				}if(steepI==true){
					if(topPoint(targetSteep)>=5){
						 if(minTopX()<getCurX()) key = ControlKeys.LEFT;
						else if (minTopX()>getCurX()) key = ControlKeys.RIGHT;	
					}
					if(topPoint(targetSteep)<5){
					if(targetSteep<getCurX()) key = ControlKeys.LEFT;
					else if (targetSteep>getCurX()) key = ControlKeys.RIGHT;
					}
				}
			}
		}
		
		else if(curPiece.getShape() ==Tetrominoes.SQUARE){	
			boolean answerSQ = false;
			int targetSQ = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				answerSQ = isThereConsecutiveRightEmpty(c,2)||isThereConsecutiveLeftEmpty(c,2);
				if(answerSQ==true){
					targetSQ = c;
					break;
				}
			} 
			if(answerSQ ==false) key = ControlKeys.DEL;
			else if(answerSQ==true){
					if(isThereConsecutiveRightEmpty(targetSQ,2)||isThereConsecutiveLeftEmpty(targetSQ,2)){
						if(isThereConsecutiveLeftEmpty(targetSQ,2)) {
							if(consecutiveLeftEmpty(targetSQ,2)<getCurX()) key = ControlKeys.LEFT;
							else if(consecutiveLeftEmpty(targetSQ,2)>getCurX()) key = ControlKeys.RIGHT;
						} else if(!isThereConsecutiveLeftEmpty(targetSQ,2)&&isThereConsecutiveRightEmpty(targetSQ,2)) {
							if(consecutiveRightEmpty(targetSQ,2)-1>getCurX()) key = ControlKeys.RIGHT;
							else if(consecutiveRightEmpty(targetSQ,2)-1<getCurX())  key = ControlKeys.LEFT;
						}
					}
					
			}
		}
		
		else  if(curPiece.getShape()==Tetrominoes.TSHAPE){
			boolean answerT = false;
			int targetT = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				if(isThereConsecutiveRightEmpty(c,3)||isThereConsecutiveLeftEmpty(c,3)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&(9>consecutiveRightEmpty(c,1))&&(0<consecutiveRightEmpty(c,1))&&(topPoint(consecutiveRightEmpty(c,1)-1)-topPoint(consecutiveRightEmpty(c,1))==1)&&(topPoint(consecutiveRightEmpty(c,1)+1)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}
				else if(!isThereConsecutiveRightEmpty(c,1)&&(isThereConsecutiveLeftEmpty(c,1))&&(9>consecutiveLeftEmpty(c,1))&&(0<consecutiveLeftEmpty(c,1))&&(topPoint(consecutiveLeftEmpty(c,1)+1)-topPoint(consecutiveLeftEmpty(c,1))==1)&&(topPoint(consecutiveLeftEmpty(c,1)-1)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&(consecutiveRightEmpty(c,1)>0)&&(topPoint(consecutiveRightEmpty(c,1)-1)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&(consecutiveLeftEmpty(c,1)<9)&&(topPoint(consecutiveLeftEmpty(c,1)+1)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&(consecutiveRightEmpty(c,1)<9)&&(topPoint(consecutiveRightEmpty(c,1)+1)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&(consecutiveLeftEmpty(c,1)>0)&&(topPoint(consecutiveLeftEmpty(c,1)-1)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerT = true;
					if(answerT==true){
					targetT = c;
					break;
					}
				}else answerT = false;
			} 
			if(answerT==false) key = ControlKeys.DEL;
			else if(answerT==true){
				if(isThereConsecutiveRightEmpty(targetT,3)){
					if(curPiece.x(0)!=1) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetT,3)-1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetT,3)-1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(!isThereConsecutiveRightEmpty(targetT,3)&&isThereConsecutiveLeftEmpty(targetT,3)){
					if(curPiece.x(0)!=1) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetT,3)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetT,3)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}
				else if(isThereConsecutiveRightEmpty(targetT,1)&&(9>consecutiveRightEmpty(targetT,1))&&(0<consecutiveRightEmpty(targetT,1))&&(topPoint(consecutiveRightEmpty(targetT,1)-1)-topPoint(consecutiveRightEmpty(targetT,1))==1)&&(topPoint(consecutiveRightEmpty(targetT,1)+1)-topPoint(consecutiveRightEmpty(targetT,1))==1)){
					if(consecutiveRightEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveRightEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
				}
				else if(!isThereConsecutiveRightEmpty(targetT,1)&&(isThereConsecutiveLeftEmpty(targetT,1))&&(9>consecutiveLeftEmpty(targetT,1))&&(0<consecutiveLeftEmpty(targetT,1))&&(topPoint(consecutiveLeftEmpty(targetT,1)+1)-topPoint(consecutiveLeftEmpty(targetT,1))==1)&&(topPoint(consecutiveLeftEmpty(targetT,1)-1)-topPoint(consecutiveLeftEmpty(targetT,1))==1)){
					if(consecutiveLeftEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveLeftEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
				}else if(isThereConsecutiveRightEmpty(targetT,1)&&(consecutiveRightEmpty(targetT,1)>0)&&(topPoint(consecutiveRightEmpty(targetT,1)-1)-topPoint(consecutiveRightEmpty(targetT,1))==1)){
					if(curPiece.x(0)!=0) key = ControlKeys.DOWN;
					else {
						if(consecutiveRightEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetT,1)&&(consecutiveLeftEmpty(targetT,1)<9)&&(topPoint(consecutiveLeftEmpty(targetT,1)+1)-topPoint(consecutiveLeftEmpty(targetT,1))==1)){
					if(curPiece.x(0)!=0) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveRightEmpty(targetT,1)&&(consecutiveRightEmpty(targetT,1)<9)&&(topPoint(consecutiveRightEmpty(targetT,1)+1)-topPoint(consecutiveRightEmpty(targetT,1))==1)){
					if(curPiece.x(0)!=0) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetT,1)&&(consecutiveLeftEmpty(targetT,1)>0)&&(topPoint(consecutiveLeftEmpty(targetT,1)-1)-topPoint(consecutiveLeftEmpty(targetT,1))==1)){
					if(curPiece.x(0)!=0) key = ControlKeys.DOWN;
					else {
						if(consecutiveLeftEmpty(targetT,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetT,1)<getCurX()) key = ControlKeys.LEFT;
					}
				}
			}
	}
	
		
		else if(curPiece.getShape() ==Tetrominoes.ZSHAPE){
			boolean answerZ = false;
			int targetZ = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				if(isThereConsecutiveRightEmpty(c,2)&&(consecutiveRightEmpty(c,2)>1)&&(topPoint(consecutiveRightEmpty(c,2)-2)-topPoint(consecutiveRightEmpty(c,2))==1)){
					answerZ = true;
					if(answerZ==true){
					targetZ = c;
					break;
					}
				}
				else if((isThereConsecutiveLeftEmpty(c,2))&&(consecutiveLeftEmpty(c,2)>0)&&(topPoint(consecutiveLeftEmpty(c,2)-1)-topPoint(consecutiveLeftEmpty(c,2))==1)){
					answerZ = true;
					if(answerZ==true){
					targetZ = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&(consecutiveRightEmpty(c,1)<9)&&(topPoint(consecutiveRightEmpty(c,1)+1)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerZ = true;
					if(answerZ==true){
					targetZ = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&(consecutiveLeftEmpty(c,1)<9)&&(topPoint(consecutiveLeftEmpty(c,1)+1)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerZ = true;
					if(answerZ==true){
					targetZ = c;
					break;
					}
				}else answerZ = false;
			}
			
			if(answerZ==false) key = ControlKeys.DEL;
			else if(answerZ==true){
					if(isThereConsecutiveRightEmpty(targetZ,2)&&(consecutiveRightEmpty(targetZ,2)>1)&&(topPoint(consecutiveRightEmpty(targetZ,2)-2)-topPoint(consecutiveRightEmpty(targetZ,2))==1)){
						if(curPiece.x(0)!=1) key = ControlKeys.UP;
						else {
							if(consecutiveRightEmpty(targetZ,2)-1>getCurX()) key = ControlKeys.RIGHT;
							else if(consecutiveRightEmpty(targetZ,2)-1<getCurX()) key = ControlKeys.LEFT;
						}
					} 
					else if((isThereConsecutiveLeftEmpty(targetZ,2))&&(consecutiveLeftEmpty(targetZ,2)>0)&&(topPoint(consecutiveLeftEmpty(targetZ,2)-1)-topPoint(consecutiveLeftEmpty(targetZ,2))==1)) {
						if(curPiece.x(0)!=1) key = ControlKeys.UP;	
						else {
							if(consecutiveLeftEmpty(targetZ,2)<getCurX()) key = ControlKeys.LEFT;
							else if(consecutiveLeftEmpty(targetZ,2)>getCurX()) key = ControlKeys.RIGHT;
						}
					}else if(isThereConsecutiveRightEmpty(targetZ,1)&&(consecutiveRightEmpty(targetZ,1)<9)&&(topPoint(consecutiveRightEmpty(targetZ,1)+1)-topPoint(consecutiveRightEmpty(targetZ,1))==1)){
						if(consecutiveRightEmpty(targetZ,1)<getCurX()) key = ControlKeys.LEFT;
						else if(consecutiveRightEmpty(targetZ,1)>getCurX()) key = ControlKeys.RIGHT;
					} 
					else if(isThereConsecutiveLeftEmpty(targetZ,1)&&(consecutiveLeftEmpty(targetZ,1)<9)&&(topPoint(consecutiveLeftEmpty(targetZ,1)+1)-topPoint(consecutiveLeftEmpty(targetZ,1))==1)) {
						if(consecutiveLeftEmpty(targetZ,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetZ,1)<getCurX()) key = ControlKeys.LEFT;
					}
			}
		}
		
		else if(curPiece.getShape() ==Tetrominoes.SSHAPE){
			boolean answerSS = false;
			int targetSS = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				if(isThereConsecutiveRightEmpty(c,2)&&(consecutiveRightEmpty(c,2)<9)&&(topPoint(consecutiveRightEmpty(c,2)+1)-topPoint(consecutiveRightEmpty(c,2))==1)){
					answerSS = true;
					if(answerSS==true){
						targetSS = c;
						break;
					}
				}else if((isThereConsecutiveLeftEmpty(c,2))&&(consecutiveLeftEmpty(c,2)<8)&&(topPoint(consecutiveLeftEmpty(c,2)+2)-topPoint(consecutiveLeftEmpty(c,2))==1)){
					answerSS = true;
					if(answerSS==true){
						targetSS = c;
						break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&(consecutiveRightEmpty(c,1)>0)&&(topPoint(consecutiveRightEmpty(c,1)-1)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerSS = true;
					if(answerSS==true){
						targetSS = c;
						break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&(consecutiveLeftEmpty(c,1)>0)&&(topPoint(consecutiveLeftEmpty(c,1)-1)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerSS = true;
					if(answerSS==true){
						targetSS = c;
						break;
					}
				}else answerSS = false;
			}
			
			if(answerSS==false) key = ControlKeys.DEL;
			else if(answerSS==true){
					if(isThereConsecutiveRightEmpty(targetSS,2)&&(consecutiveRightEmpty(targetSS,2)<9)&&(topPoint(consecutiveRightEmpty(targetSS,2)+1)-topPoint(consecutiveRightEmpty(targetSS,2))==1)){
						if(curPiece.x(0)!=1) key = ControlKeys.UP;
						else {
							if(consecutiveRightEmpty(targetSS,2)>getCurX()) key = ControlKeys.RIGHT;
							else if(consecutiveRightEmpty(targetSS,2)<getCurX()) key = ControlKeys.LEFT;
						}
					} 
					else if((isThereConsecutiveLeftEmpty(targetSS,2))&&(consecutiveLeftEmpty(targetSS,2)<8)&&(topPoint(consecutiveLeftEmpty(targetSS,2)+2)-topPoint(consecutiveLeftEmpty(targetSS,2))==1)) {
						if(curPiece.x(0)!=1) key = ControlKeys.UP;	
						else {
							if(consecutiveLeftEmpty(targetSS,2)+1<getCurX()) key = ControlKeys.LEFT;
							else if(consecutiveLeftEmpty(targetSS,2)+1>getCurX()) key = ControlKeys.RIGHT;
						}
					}else if(isThereConsecutiveRightEmpty(targetSS,1)&&(consecutiveRightEmpty(targetSS,1)>0)&&(topPoint(consecutiveRightEmpty(targetSS,1)-1)-topPoint(consecutiveRightEmpty(targetSS,1))==1)){
						if(consecutiveRightEmpty(targetSS,1)<getCurX()) key = ControlKeys.LEFT;
						else if(consecutiveRightEmpty(targetSS,1)>getCurX()) key = ControlKeys.RIGHT;
					} 
					else if(isThereConsecutiveLeftEmpty(targetSS,1)&&(consecutiveLeftEmpty(targetSS,1)>0)&&(topPoint(consecutiveLeftEmpty(targetSS,1)-1)-topPoint(consecutiveLeftEmpty(targetSS,1))==1)) {
						if(consecutiveLeftEmpty(targetSS,1)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetSS,1)<getCurX()) key = ControlKeys.LEFT;
					}	
				
			}
		}
		
		else if(curPiece.getShape() ==Tetrominoes.JSHAPE){
			boolean answerJ = false;
			int targetJ = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				if(isThereConsecutiveRightEmpty(c,3)||isThereConsecutiveLeftEmpty(c,3)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,2)||isThereConsecutiveLeftEmpty(c,2)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&consecutiveRightEmpty(c,1)>1&&(topPoint(consecutiveRightEmpty(c,1)-1)-topPoint(consecutiveRightEmpty(c,1))==1)&&(topPoint(consecutiveRightEmpty(c,1)-2)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&consecutiveLeftEmpty(c,1)>1&&(topPoint(consecutiveLeftEmpty(c,1)-1)-topPoint(consecutiveLeftEmpty(c,1))==1)&&(topPoint(consecutiveLeftEmpty(c,1)-2)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&consecutiveLeftEmpty(c,1)<9&&(topPoint(consecutiveLeftEmpty(c,1)+1)-topPoint(consecutiveLeftEmpty(c,1))==2)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&consecutiveRightEmpty(c,1)<9&&(topPoint(consecutiveRightEmpty(c,1)+1)-topPoint(consecutiveRightEmpty(c,1))==2)){
					answerJ = true;
					if(answerJ==true){
					targetJ = c;
					break;
					}
				}else answerJ = false;
			} 
			if(answerJ==false) key = ControlKeys.DEL;
			else if(answerJ==true){
				if(isThereConsecutiveLeftEmpty(targetJ,3)){
					if(curPiece.x(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetJ,3)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetJ,3)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}
				else if(isThereConsecutiveRightEmpty(targetJ,3)){
					if(curPiece.x(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetJ,3)-1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetJ,3)-1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveRightEmpty(targetJ,2)){
					if(curPiece.y(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetJ,2)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetJ,2)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetJ,2)){
					if(curPiece.y(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetJ,2)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetJ,2)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveRightEmpty(targetJ,1)&&consecutiveRightEmpty(targetJ,1)>1&&(topPoint(consecutiveRightEmpty(targetJ,1)-1)-topPoint(consecutiveRightEmpty(targetJ,1))==1)&&(topPoint(consecutiveRightEmpty(targetJ,1)-2)-topPoint(consecutiveRightEmpty(targetJ,1))==1)){
					if(curPiece.y(0)!=-1) key = ControlKeys.DOWN;
					else {
						if(consecutiveRightEmpty(targetJ,1)-1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetJ,1)-1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetJ,1)&&consecutiveLeftEmpty(targetJ,1)>1&&(topPoint(consecutiveLeftEmpty(targetJ,1)-1)-topPoint(consecutiveLeftEmpty(targetJ,1))==1)&&(topPoint(consecutiveLeftEmpty(targetJ,1)-2)-topPoint(consecutiveLeftEmpty(targetJ,1))==1)){
					if(curPiece.y(0)!=-1) key = ControlKeys.DOWN;
					else {
						if(consecutiveLeftEmpty(targetJ,1)-1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetJ,1)-1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetJ,1)&&consecutiveLeftEmpty(targetJ,1)<9&&(topPoint(consecutiveLeftEmpty(targetJ,1)+1)-topPoint(consecutiveLeftEmpty(targetJ,1))==2)){
					if(consecutiveLeftEmpty(targetJ,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveLeftEmpty(targetJ,1)<getCurX()) key = ControlKeys.LEFT;
				}else if(isThereConsecutiveRightEmpty(targetJ,1)&&consecutiveRightEmpty(targetJ,1)<9&&(topPoint(consecutiveRightEmpty(targetJ,1)+1)-topPoint(consecutiveRightEmpty(targetJ,1))==2)){
					if(consecutiveRightEmpty(targetJ,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveRightEmpty(targetJ,1)<getCurX()) key = ControlKeys.LEFT;
				}
			}
		}
		
		else if(curPiece.getShape() ==Tetrominoes.LSHAPE){
			boolean answerL = false;
			int targetL = 0;
			for (int c = 0; c<= topPoint(maxTopX()); c++){
				if(isThereConsecutiveRightEmpty(c,3)||isThereConsecutiveLeftEmpty(c,3)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,2)||isThereConsecutiveRightEmpty(c,2)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&consecutiveLeftEmpty(c,1)<8&&(topPoint(consecutiveLeftEmpty(c,1)+1)-topPoint(consecutiveLeftEmpty(c,1))==1)&&(topPoint(consecutiveLeftEmpty(c,1)+2)-topPoint(consecutiveLeftEmpty(c,1))==1)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&consecutiveRightEmpty(c,1)<8&&(topPoint(consecutiveRightEmpty(c,1)+1)-topPoint(consecutiveRightEmpty(c,1))==1)&&(topPoint(consecutiveRightEmpty(c,1)+2)-topPoint(consecutiveRightEmpty(c,1))==1)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else if(isThereConsecutiveRightEmpty(c,1)&&consecutiveRightEmpty(c,1)>0&&(topPoint(consecutiveRightEmpty(c,1)-1)-topPoint(consecutiveRightEmpty(c,1))==2)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else if(isThereConsecutiveLeftEmpty(c,1)&&consecutiveLeftEmpty(c,1)>0&&(topPoint(consecutiveLeftEmpty(c,1)-1)-topPoint(consecutiveLeftEmpty(c,1))==2)){
					answerL = true;
					if(answerL==true){
					targetL = c;
					break;
					}
				}else answerL = false;
			} 
			if(answerL==false) key = ControlKeys.DEL;
			else if(answerL==true){
				if(isThereConsecutiveRightEmpty(targetL,3)){
					if(curPiece.x(0)!=1) key = ControlKeys.DOWN;
					else {
						if(consecutiveRightEmpty(targetL,3)-1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetL,3)-1<getCurX()) key = ControlKeys.LEFT;
					}
				}
				else if(isThereConsecutiveLeftEmpty(targetL,3)){
					if(curPiece.x(0)!=1) key = ControlKeys.DOWN;
					else {
						if(consecutiveLeftEmpty(targetL,3)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetL,3)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if((isThereConsecutiveLeftEmpty(targetL,2))){
					if(curPiece.x(0)!=1) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetL,2)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetL,2)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if((isThereConsecutiveRightEmpty(targetL,2))){
					if(curPiece.x(0)!=1) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetL,2)>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetL,2)<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveLeftEmpty(targetL,1)&&consecutiveLeftEmpty(targetL,1)<8&&(topPoint(consecutiveLeftEmpty(targetL,1)+1)-topPoint(consecutiveLeftEmpty(targetL,1))==1)&&(topPoint(consecutiveLeftEmpty(targetL,1)+2)-topPoint(consecutiveLeftEmpty(targetL,1))==1)){
					if(curPiece.y(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveLeftEmpty(targetL,1)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveLeftEmpty(targetL,1)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveRightEmpty(targetL,1)&&consecutiveRightEmpty(targetL,1)<8&&(topPoint(consecutiveRightEmpty(targetL,1)+1)-topPoint(consecutiveRightEmpty(targetL,1))==1)&&(topPoint(consecutiveRightEmpty(targetL,1)+2)-topPoint(consecutiveRightEmpty(targetL,1))==1)){
					if(curPiece.y(0)!=-1) key = ControlKeys.UP;
					else {
						if(consecutiveRightEmpty(targetL,1)+1>getCurX()) key = ControlKeys.RIGHT;
						else if(consecutiveRightEmpty(targetL,1)+1<getCurX()) key = ControlKeys.LEFT;
					}
				}else if(isThereConsecutiveRightEmpty(targetL,1)&&consecutiveRightEmpty(targetL,1)>0&&(topPoint(consecutiveRightEmpty(targetL,1)-1)-topPoint(consecutiveRightEmpty(targetL,1))==2)){
					if(consecutiveRightEmpty(targetL,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveRightEmpty(targetL,1)<getCurX()) key = ControlKeys.LEFT;
				}else if(isThereConsecutiveLeftEmpty(targetL,1)&&consecutiveLeftEmpty(targetL,1)>0&&(topPoint(consecutiveLeftEmpty(targetL,1)-1)-topPoint(consecutiveLeftEmpty(targetL,1))==2)){
					if(consecutiveLeftEmpty(targetL,1)>getCurX()) key = ControlKeys.RIGHT;
					else if(consecutiveLeftEmpty(targetL,1)<getCurX()) key = ControlKeys.LEFT;
				}
			}
		}
		
		else { key = ControlKeys.DEL; }
		return key;
	}
}
