import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class ButtonsInfo
{
public JButton button;
public String buttonName;
public int rowIndex;
public int columnIndex;
}
class KingValidator
{
//here x1,y1 are coordinates of button for which we are looking valid 
//positions and x2,y2 are the coordinates of new position
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons,java.util.List<JButton> validButtons[][])
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
int i,j;
JButton button;
java.util.List<JButton> b;
name=buttons[x2][y2].buttonName;
if(name.equals("") || name.charAt(0)!=buttonStartsWith) 
{
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
if(buttons[i][j].buttonName.equals(""))continue;
if(buttons[i][j].buttonName.charAt(0)==buttonStartsWith)continue;
b=validButtons[i][j];
if(b.size()!=0)
{
if(b.contains(buttons[x2][y2].button))
{
return false;
}
}
}
}
return true;
}
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo,java.util.List<JButton> validButtons[][])
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
String name;
int i,j;
i=rowIndex+1;
j=columnIndex;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex-1;
j=columnIndex;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex-1;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex-1;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);
i=rowIndex+1;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons)) list.add(buttons[i][j].button);

i=rowIndex+1;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons,validButtons))list.add(buttons[i][j].button);
return list;
}
}


class RookValidator
{
//here x1,y1 are coordinates of button for which we are looking valid 
//positions and x2,y2 are the coordinates of new position
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons)
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
name=buttons[x2][y2].buttonName;
if(name.equals("") || name.charAt(0)!=buttonStartsWith) return true;
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo)
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
String name;
int i,j,k;
//Checking  down side of rook 
i=rowIndex+1;
j=columnIndex;
while(i<=7)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
/*
break because you cannot cross any piece ,if you find a button which contains a piece and if it is valid then we have to break
or if it a button which does not contain any piece then also it is a valid move but we have to continue till we did not find a button which contains some piece
*/
}
else break;  // break because if your rook is of black color and you found any valid position or any another piece of black color then you cannot move beyond that piece
i++; 
}          

//Checking upper side of rook
i=rowIndex-1;
j=columnIndex;
while(i>=0)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{ 
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
}
else break; 
i--;
}

//Checking right side of rook
i=rowIndex;
j=columnIndex+1;
while(j<=7)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{ 
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
}
else break; 
j++;
}

//Checking left side of rook
i=rowIndex;
j=columnIndex-1;
while(j>=0)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) 
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break; 
j--;
}
return list;
}
}


class KnightValidator
{
//here x1,y1 are coordinates of button for which we are looking valid 
//positions and x2,y2 are the coordinates of new position
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons)
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
name=buttons[x2][y2].buttonName;
if(name.equals("") || name.charAt(0)!=buttonStartsWith) return true;
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo)
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
String name;
int i,j,k;
i=rowIndex-2;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex-1;
j=columnIndex+2;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex+1;
j=columnIndex+2;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);


i=rowIndex+2;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex+2;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex+1;
j=columnIndex-2;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex-1;
j=columnIndex-2;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

i=rowIndex-2;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons))list.add(buttons[i][j].button);

return list;
}
}


class BishopValidator
{
//here x1,y1 are coordinates of button for which we are looking valid 
//positions and x2,y2 are the coordinates of new position
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons)
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
name=buttons[x2][y2].buttonName;
if(name.equals("") || name.charAt(0)!=buttonStartsWith) return true;
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo)
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
String name;
int i,j,k;

//Checking upper right side of Bishop
for(i=rowIndex-1,j=columnIndex+1;i>=0 && j<=7;i--,j++)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking lower right side of Bishop
for(i=rowIndex+1,j=columnIndex+1;i<=7 && j<=7;i++,j++)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking lower left side of Bishop
for(i=rowIndex+1,j=columnIndex-1;i<=7 && j>=0;i++,j--)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking upper left side of Bishop
for(i=rowIndex-1,j=columnIndex-1;i>=0 && j>=0;i--,j--)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

return list;
}
}

class QueenValidator
{
//here x1,y1 are coordinates of button for which we are looking valid 
//positions and x2,y2 are the coordinates of new position
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons)
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
name=buttons[x2][y2].buttonName;
if(name.equals("") || name.charAt(0)!=buttonStartsWith) return true;
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo)
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
String name;
int i,j,k;

//Checking upper right side of Queen
for(i=rowIndex-1,j=columnIndex+1;i>=0 && j<=7;i--,j++)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking lower right side of Queen
for(i=rowIndex+1,j=columnIndex+1;i<=7 && j<=7;i++,j++)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking lower left side of Queen
for(i=rowIndex+1,j=columnIndex-1;i<=7 && j>=0;i++,j--)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}

//Checking upper left side of Queen
for(i=rowIndex-1,j=columnIndex-1;i>=0 && j>=0;i--,j--)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break;
}


//Checking  down side of Queen
i=rowIndex+1;
j=columnIndex;
while(i<=7)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
}
else break;  // break because if your rook is of black color and you found any valid position or any another piece of black color then you cannot move beyond that piece
i++; 
}          

//Checking upper side of Queen
i=rowIndex-1;
j=columnIndex;
while(i>=0)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{ 
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
}
else break; 
i--;
}

//Checking right side of Queen
i=rowIndex;
j=columnIndex+1;
while(j<=7)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons))
{ 
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals("")) break;
}
else break; 
j++;
}

//Checking left side of Queen
i=rowIndex;
j=columnIndex-1;
while(j>=0)
{
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) 
{
list.add(buttons[i][j].button);
if(!buttons[i][j].buttonName.equals(""))break;
}
else break; 
j--;
}

return list;
}
}


class PawnValidator
{
public boolean isValidMove(int x1,int y1,int x2,int y2,ButtonsInfo [][]buttons)
{
if(x2<0 || x2>7 || y2<0 || y2>7)return false;
ButtonsInfo buttonInfo=buttons[x1][y1];
char buttonStartsWith=buttonInfo.buttonName.charAt(0);
String name;
name=buttons[x2][y2].buttonName;
if(name.equals(""))return false;
if(name.charAt(0)!=buttonStartsWith) return true;
return false;
}
//we are recieving data structure also to find which are the validate positions
public java.util.List<JButton> generateValidMoves(ButtonsInfo [][]buttons,ButtonsInfo buttonInfo)
{
java.util.List<JButton> list=new ArrayList<>();
int rowIndex=buttonInfo.rowIndex;
int columnIndex=buttonInfo.columnIndex;
int i,j;
if(buttonInfo.buttonName.startsWith("B"))
{
i=rowIndex+1;
j=columnIndex;
if(i>=0 && j>=0 && i<=7 && j<=7 && (buttons[i][j].buttonName.equals(""))) 
{
list.add(buttons[i][j].button);
}
i=rowIndex+1;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) list.add(buttons[i][j].button);
i=rowIndex+1;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) list.add(buttons[i][j].button);
}
else
{
i=rowIndex-1;
j=columnIndex;
if(i>=0 && j>=0 && i<=7 && j<=7 && (buttons[i][j].buttonName.equals(""))) 
{
list.add(buttons[i][j].button);
}
i=rowIndex-1;
j=columnIndex-1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) list.add(buttons[i][j].button);
i=rowIndex-1;
j=columnIndex+1;
if(isValidMove(rowIndex,columnIndex,i,j,buttons)) list.add(buttons[i][j].button);
}
return list;
}
}


class Chess extends JFrame implements ActionListener
{
private ButtonsInfo buttons[][];
private java.util.List<JButton> validButtons[][];
private Container container;
private Icon icon1;
private Icon icon2;
private boolean firstClicked;
private boolean secondClicked;
private JButton button1;
private JButton button2;
private boolean blackChance;
private boolean whiteChance;
private JPanel p1,p2,p3,p4,p5,p6;
Chess()
{
int i,j;
buttons=new ButtonsInfo[8][8];
blackChance=true;
whiteChance=false;
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
buttons[i][j]=new ButtonsInfo();
//for knight
if((i==0 && j==1) || (i==0 && j==6))
{
buttons[i][j].button=new JButton(new ImageIcon("black_knight_image.png"));
buttons[i][j].buttonName=new String("BT");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if((i==7 && j==1) || (i==7 && j==6))
{
buttons[i][j].button=new JButton(new ImageIcon("white_knight_image.png"));
buttons[i][j].buttonName=new String("WT");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
//for bishop
if((i==0 && j==2) || (i==0 && j==5))
{
buttons[i][j].button=new JButton(new ImageIcon("black_bishop_image.png"));
buttons[i][j].buttonName=new String("BB");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if((i==7 && j==2) || (i==7 && j==5))
{
buttons[i][j].button=new JButton(new ImageIcon("white_bishop_image.png"));
buttons[i][j].buttonName=new String("WB");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
//for rook
if((i==0 && j==0) || (i==0 && j==7))
{
buttons[i][j].button=new JButton(new ImageIcon("black_rook_image.png"));
buttons[i][j].buttonName=new String("BR");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if((i==7 && j==0) || (i==7 && j==7))
{
buttons[i][j].button=new JButton(new ImageIcon("white_rook_image.png"));
buttons[i][j].buttonName=new String("WR");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
//for queen
if(i==0 && j==3)
{
buttons[i][j].button=new JButton(new ImageIcon("black_queen_image.png"));
buttons[i][j].buttonName=new String("BQ");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if(i==7 && j==3)
{
buttons[i][j].button=new JButton(new ImageIcon("white_queen_image.png"));
buttons[i][j].buttonName=new String("WQ");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
//for king
if(i==0 && j==4)
{
buttons[i][j].button=new JButton(new ImageIcon("black_king_image.png"));
buttons[i][j].buttonName=new String("BK");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if(i==7 && j==4)
{
buttons[i][j].button=new JButton(new ImageIcon("white_king_image.png"));
buttons[i][j].buttonName=new String("WK");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}

//for pawn
if(i==1)
{
buttons[i][j].button=new JButton(new ImageIcon("black_pawn_image.png"));
buttons[i][j].buttonName=new String("BP");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if(i==6)
{
buttons[i][j].button=new JButton(new ImageIcon("white_pawn_image.png"));
buttons[i][j].buttonName=new String("WP");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if(i>=2 && i<=5) 
{
buttons[i][j].button=new JButton();
buttons[i][j].buttonName=new String("");
buttons[i][j].rowIndex=i;
buttons[i][j].columnIndex=j;
}
if(i%2==0 && j%2==0)buttons[i][j].button.setBackground(Color.BLACK);
if(i%2==0 && j%2!=0)buttons[i][j].button.setBackground(Color.WHITE);

if(i%2!=0 && j%2==0)buttons[i][j].button.setBackground(Color.WHITE);
if(i%2!=0 && j%2!=0)buttons[i][j].button.setBackground(Color.BLACK);
buttons[i][j].button.addActionListener(this);
}
}
initailizeDataStructure();


p1=new JPanel();
p1.setLayout(new GridLayout(8,2));
p1.setBackground(Color.ORANGE);
JLabel l1[]=new JLabel[8];
int k=8;
for(i=0;i<=7;i++)
{
p1.add(new JLabel(" "));
l1[i]=new JLabel(new Integer(k).toString());
k--;
p1.add(l1[i]);
}


p2=new JPanel();
p2.setLayout(new GridLayout(1,8));
p2.setBackground(Color.ORANGE);
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));
p2.add(new JLabel(" "));

p3=new JPanel();
p3.setLayout(new GridLayout(8,8));
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
p3.add(buttons[i][j].button);
}
}


JLabel l2[]=new JLabel[8];
p4=new JPanel();
p4.setLayout(new GridLayout(1,24));
p4.setBackground(Color.ORANGE);
char g='A';
k=1;
j=0;
for(i=0;i<=23;i++)
{
if(i==k)
{
l2[j]=new JLabel(Character.toString(g));
p4.add(l2[j]);
j++;
g++;
k+=3;
}
else
{
p4.add(new JLabel(" "));
}
}

p5=new JPanel();
p5.setLayout(new BorderLayout());
p5.add(p2,BorderLayout.NORTH);
p5.add(p3,BorderLayout.CENTER);
p5.add(p4,BorderLayout.SOUTH);

p6=new JPanel();
p6.setLayout(new GridLayout(8,1));
p6.setBackground(Color.ORANGE);
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));
p6.add(new JLabel("     "));


container=getContentPane();
container.setLayout(new BorderLayout());
container.add(p1,BorderLayout.WEST);
container.add(p5,BorderLayout.CENTER);
container.add(p6,BorderLayout.EAST);


Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
int width=680;
int height=680;
int x=(d.width/2)-(width/2);
int y=(d.height/2)-(height/2);
setLocation(x,y);
setSize(width,height);
setVisible(true);
}
public void actionPerformed(ActionEvent ev)
{
int i,j;
ButtonsInfo buttonInfo=null;
if(firstClicked==false)
{
button1=(JButton)ev.getSource();
icon1=button1.getIcon();
firstClicked=true;
if(icon1==null)
{
JOptionPane.showMessageDialog(this,"This is not a valid move");
firstClicked=false;
return;
}
} //first clicked==false
else
{
button2=(JButton)ev.getSource();

for(i=0;i<=7;i++)
{
for(j=0;j<=7;j++)
{
if(buttons[i][j].button==button1)
{
buttonInfo=buttons[i][j];
break;
}
}
}
if(blackChance==true && buttonInfo.buttonName.startsWith("W"))
{
firstClicked=false;
JOptionPane.showMessageDialog(this,"It's not your chance");
return;
}

if(whiteChance==true && buttonInfo.buttonName.startsWith("B"))
{
firstClicked=false;
JOptionPane.showMessageDialog(this,"It's not your chance");
return;
}
if(button1==button2)
{
firstClicked=false;
return;
}
icon2=button2.getIcon();
if((icon1==null && icon2==null) || (icon1==null && icon2!=null))
{
firstClicked=false;
return;
}
//check whether it is black chance or white chance
updateDataStructure(button1,button2);
firstClicked=false;
}
}
public void initailizeDataStructure()
{
int i,j;
ButtonsInfo buttonInfo;
validButtons=new ArrayList[8][8];
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
validButtons[i][j]=new ArrayList<JButton>();
//For Black Knight
if((i==0 && j==1) || (i==0 && j==6))
{
validButtons[i][j].add(buttons[i+2][j-1].button);
validButtons[i][j].add(buttons[i+2][j+1].button);
}
//For White Knight
if((i==7 && j==1) || (i==7 && j==6))
{
validButtons[i][j].add(buttons[i-2][j-1].button);
validButtons[i][j].add(buttons[i-2][j+1].button);
}
//For Black Pawn
if(i==1)
{
validButtons[i][j].add(buttons[i+1][j].button);
}
//For White Pawn
if(i==6)
{
validButtons[i][j].add(buttons[i-1][j].button);
}
}
} 
}
public void updateDataStructure(JButton button1,JButton button2)
{
int i,j;
java.util.List<JButton> list;
ButtonsInfo buttonInfo1=null;
ButtonsInfo buttonInfo2=null;
java.util.List<JButton> l1;
int rowIndex,columnIndex;
String button1Name;
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
if(buttons[i][j].button==button1)buttonInfo1=buttons[i][j];
if(buttons[i][j].button==button2)buttonInfo2=buttons[i][j];
}
}
rowIndex=buttonInfo1.rowIndex;
columnIndex=buttonInfo1.columnIndex;
list=validButtons[rowIndex][columnIndex];
if(list.contains(button2))
{
//Changing button1 data
button1.setIcon(null);
button1Name=buttonInfo1.buttonName;
buttonInfo1.buttonName="";
validButtons[rowIndex][columnIndex].clear();
// for updating button2

i=buttonInfo2.rowIndex;
j=buttonInfo2.columnIndex;
l1=validButtons[i][j];
if(l1.size()!=0)validButtons[i][j].clear();
button2.setIcon(icon1);
buttonInfo2.buttonName=button1Name;


if(buttonInfo2.buttonName.equals("BP") || buttonInfo2.buttonName.equals("WP"))
{
PawnValidator pv=new PawnValidator();
validButtons[i][j]=pv.generateValidMoves(buttons,buttonInfo2);
}
if(buttonInfo2.buttonName.equals("BR") || buttonInfo2.buttonName.equals("WR"))
{
RookValidator rv=new RookValidator();
validButtons[i][j]=rv.generateValidMoves(buttons,buttonInfo2);
}
if(buttonInfo2.buttonName.equals("BT") || buttonInfo2.buttonName.equals("WT"))
{
KnightValidator tv=new KnightValidator();
validButtons[i][j]=tv.generateValidMoves(buttons,buttonInfo2);
}
if(buttonInfo2.buttonName.equals("BB") || buttonInfo2.buttonName.equals("WB"))
{
BishopValidator bv=new BishopValidator();
validButtons[i][j]=bv.generateValidMoves(buttons,buttonInfo2);
}
if(buttonInfo2.buttonName.equals("BQ") || buttonInfo2.buttonName.equals("WQ"))
{
QueenValidator qv=new QueenValidator();
validButtons[i][j]=qv.generateValidMoves(buttons,buttonInfo2);
}


updateLinkedList();
//if it is valid position then change chance
if(blackChance==true)
{
blackChance=false;
whiteChance=true;
}
else
{
whiteChance=false;
blackChance=true;
}
}
}
public void updateLinkedList()
{
int i,j,k1,l1,k2,l2,p,q,r;
k1=k2=l1=l2=0;
java.util.List<JButton> b,b1,b2,b3;
ButtonsInfo buttonInfo;
JButton button1=null;  //for White King
JButton button2=null; //for black king
JButton but1,but2;
int found1=0;
int found2=0;
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
buttonInfo=buttons[i][j];
validButtons[i][j].clear(); //clearing previous list
if(buttonInfo.buttonName.equals("BP") || buttonInfo.buttonName.equals("WP"))
{
PawnValidator pv=new PawnValidator();
validButtons[i][j]=pv.generateValidMoves(buttons,buttonInfo);
}
if(buttonInfo.buttonName.equals("BR") || buttonInfo.buttonName.equals("WR"))
{
RookValidator rv=new RookValidator();
validButtons[i][j]=rv.generateValidMoves(buttons,buttonInfo);
}
if(buttonInfo.buttonName.equals("BT") || buttonInfo.buttonName.equals("WT"))
{
KnightValidator tv=new KnightValidator();
validButtons[i][j]=tv.generateValidMoves(buttons,buttonInfo);
}
if(buttonInfo.buttonName.equals("BB") || buttonInfo.buttonName.equals("WB"))
{
BishopValidator bv=new BishopValidator();
validButtons[i][j]=bv.generateValidMoves(buttons,buttonInfo);
}
if(buttonInfo.buttonName.equals("BQ") || buttonInfo.buttonName.equals("WQ"))
{
QueenValidator qv=new QueenValidator();
validButtons[i][j]=qv.generateValidMoves(buttons,buttonInfo);
}
if(buttonInfo.buttonName.equals("BK") || buttonInfo.buttonName.equals("WK"))
{
if(buttonInfo.buttonName.equals("WK"))
{
button1=buttonInfo.button;
k1=i;
l1=j;
}
if(buttonInfo.buttonName.equals("BK"))
{
button2=buttonInfo.button;
k2=i;
l2=j;
}
KingValidator kv=new KingValidator();
validButtons[i][j]=kv.generateValidMoves(buttons,buttonInfo,validButtons);
}
}
}
//Checking if white king is a valid move
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
if(buttons[i][j].buttonName.startsWith("W"))continue;
if(buttons[i][j].buttonName.equals(""))continue;b1=validButtons[i][j];
if(b1.contains(button1))
{
b2=validButtons[k1][l1];
if(b2.size()==0) //There is no valid move for king
{

but1=buttons[i][j].button;
for(p=0;p<8;p++)
{
for(q=0;q<8;q++)
{
if(buttons[i][j].buttonName.startsWith("B"))continue;
b=validButtons[p][q];
if(b.contains(but1))
{
JOptionPane.showMessageDialog(this,"Check to White King");
found1=1;
break;
}
}
if(found1==1)break;
}
//Still there is a chance to save the white king by other white pieces

Boolean saved=canBeSaved(buttons[i][j],button2,k2,l2);
if(saved==true)
{
JOptionPane.showMessageDialog(this,"Check to White King");
found1=1;
}

if(found1==0) JOptionPane.showMessageDialog(this,"Result: Black Wins");

}// b2.size ends
else
{
JOptionPane.showMessageDialog(this,"Check to White King");
}//else ends
}//if b1.contains ends
}//for loop ends of j
}//for loop ends of i


//Checking if black king is a valid move
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
if(buttons[i][j].buttonName.startsWith("B"))continue;
if(buttons[i][j].buttonName.equals(""))continue;
b1=validButtons[i][j];
if(b1.contains(button2))
{
b3=validButtons[k2][l2];
if(b3.size()==0)
{
but2=buttons[i][j].button;
for(p=0;p<8;p++)
{
for(q=0;q<8;q++)
{
if(buttons[i][j].buttonName.startsWith("W"))continue;
b=validButtons[p][q];
if(b.contains(but2))
{
JOptionPane.showMessageDialog(this,"Check to Black King");
found2=1;
break;
}
if(found2==1)break;
}
if(found2==1)break;
}
//Still there is a chance to save the black king by other black pieces

Boolean saved=canBeSaved(buttons[i][j],button2,k2,l2);
if(saved==true)
{
JOptionPane.showMessageDialog(this,"Check to Black King");
found2=1;
}

if(found2==0)JOptionPane.showMessageDialog(this,"Result: White Wins");
}// b3.size ends
else
{
JOptionPane.showMessageDialog(this,"Check to Black King");
}//else ends
if(b3.size()!=0)b3.clear();
}//if b1.contains ends
}//for loop ends of j
}//for loop ends of i
}

Boolean canBeSaved(ButtonsInfo buttonInfo,JButton button,int k,int l)
{
//Here buttonInfo contains the information of the that is giving check to the king
//button if the King Button
//k and l are the row and column index of king
ButtonsInfo kingInfo=buttons[k][l];
char kingNameStartsWith=kingInfo.buttonName.charAt(0);
int i,j,p,q;
Boolean found=false;
i=buttonInfo.rowIndex;
j=buttonInfo.columnIndex;
java.util.List<JButton> b; 
java.util.List<JButton> list=new ArrayList<>();
if(buttonInfo.buttonName.endsWith("B"))// Bishop has given check to king
{
//upper right side
if(i>k && j<l)
{
for(p=i,q=j;p>k && q<l;p--,q++)
{
list.add(buttons[p][q].button);
}
}
//lower right side
else if(i<k && j<l)
{
for(p=i,q=j;p<k && q<l;p++,q++)
{
list.add(buttons[p][q].button);
}
}
//lower left side
else if(i<k && j>l)
{
for(p=i,q=j;p<k && q>l;p++,q--)
{
list.add(buttons[p][q].button);
}
}
//upper left side
else
{
for(p=i,q=j;p>k && q>l;p--,q--)
{
list.add(buttons[p][q].button);
}
}
}
else if(buttonInfo.buttonName.endsWith("R"))//Rook has given check to king
{
//upper side
if(i>k && j==l)
{
for(p=i,q=j;p>k;p--)
{
list.add(buttons[p][q].button);
}
}
//right side
else if(i==k && j<l)
{
for(p=i,q=j;q<l;q++)
{
list.add(buttons[p][q].button);
}
}
//down side
else if(i<k && j==l)
{
for(p=i,q=j;p<k;p++)
{
list.add(buttons[p][q].button);
}
}
//left side
else
{
for(p=i,q=j;q>l;q--)
{
list.add(buttons[p][q].button);
}
}
}
else if(buttonInfo.buttonName.endsWith("Q"))//Queen has given check to king
{
//upper right side
if(i>k && j<l)
{
for(p=i,q=j;p>k && q<l;p--,q++)
{
list.add(buttons[p][q].button);
}
}
//lower right side
else if(i<k && j<l)
{
for(p=i,q=j;p<k && q<l;p++,q++)
{
list.add(buttons[p][q].button);
}
}
//lower left side
else if(i<k && j>l)
{
for(p=i,q=j;p<k && q>l;p++,q--)
{
list.add(buttons[p][q].button);
}
}
//upper left side
else
{
for(p=i,q=j;p>k && q>l;p--,q--)
{
list.add(buttons[p][q].button);
}
}

//upper side
if(i>k && j==l)
{
for(p=i,q=j;p>k;p--)
{
list.add(buttons[p][q].button);
}
}
//right side
else if(i==k && j<l)
{
for(p=i,q=j;q<l;q++)
{
list.add(buttons[p][q].button);
}
}
//down side
else if(i<k && j==l)
{
for(p=i,q=j;p<k;p++)
{
list.add(buttons[p][q].button);
}
}
//left side
else
{
for(p=i,q=j;q>l;q--)
{
list.add(buttons[p][q].button);
}
}
}
else return true; //it will be pawn only and pawn can be killed by the king itself
for(i=0;i<8;i++)
{
for(j=0;j<8;j++)
{
if(buttons[i][j].buttonName.equals(""))continue;
if(buttons[i][j].buttonName.charAt(0)!=kingNameStartsWith)continue;
b=validButtons[i][j];
if(b.size()!=0)
{
for(JButton b8:b)
{
found=list.contains(b8);
if(found==true)break;
}// for b8:b
}//b.size()!=0
if(found==true)break;
}
if(found==true)break;
}
return found;
}
}
class ChessBoard3
{
public static void main(String gg[])
{
Chess c=new Chess();
}
}