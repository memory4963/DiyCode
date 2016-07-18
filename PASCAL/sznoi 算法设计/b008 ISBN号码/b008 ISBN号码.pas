Var a:array[1..9]of char;
i,j,n,m:longint;
c,r:char;
Begin
i:=1;
m:=0;
while i<=9 do Begin
read(a[i]);
if a[i]<>'-' Then Begin
m:=m+(ord(a[i])-48)*i;
inc(i);//相当于i:=i+1;
End;
End;
read(c);
read(c);
readln;
if m mod 11=10 Then r:='X' else r:=chr(ord('0')+(m mod 11));
if c=r Then writeln('Right') else writeln(a[1],'-',a[2],a[3],a[4],'-',a[5],a[6],a[7],a[8],a[9],'-',r);
End.
