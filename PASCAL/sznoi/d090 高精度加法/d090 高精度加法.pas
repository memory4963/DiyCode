var st:string;
      x,y:array[0..101]of integer;
      i,j,l1,l2:integer;
begin
    readln(st);
    l1:=length(st);
    for i:=0 to 101 do x[i]:=0;
    for i:=l1 downto 1 do
       x[l1-i]:=ord(st[i])-ord('0');
    readln(st);
    l2:=length(st);
    for i:=0 to 101 do y[i]:=0;
    for i:=l2 downto 1 do
       y[l2-i]:=ord(st[i])-ord('0');
    if l1<l2 then l1:=l2;
    for i:=0  to  l1  do
       begin
           x[i]:=x[i]+y[i];
           x[i+1]:=x[i+1]+x[i] div 10;
           x[i]:=x[i] mod 10;
       end;
       j:=101;
   while x[j]=0 do j:=j-1;
   for i:=j downto 0 do write(x[i]);
end.
