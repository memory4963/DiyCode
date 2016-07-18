var
w:array[1..4]of integer;
t:char;
i,j,n:integer;
u:array[1..4] of char;
begin
u[1]:='A';
u[2]:='B';
u[3]:='C';
u[4]:='D';
repeat
 read(t);
 case t of
  'A':w[1]:=w[1]+1;
  'B':w[2]:=w[2]+1;
  'C':w[3]:=w[3]+1;
  'D':w[4]:=w[4]+1;
 end;
until t='#';
begin
 for i:=1 to 3 do
  for j:= 4 downto i+1 do
   if w[j-1]<w[j] then
    begin
     n:=w[j-1];
     w[j-1]:=w[j];
     w[j]:=n;
     t:=u[j-1];
     u[j-1]:=u[j];
     u[j]:=t;
    end;
end;
for i:= 1 to 4 do writeln(u[i],' : ',w[i]);
end.
