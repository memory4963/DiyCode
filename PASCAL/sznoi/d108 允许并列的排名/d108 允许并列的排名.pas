var
t:array[1..1000]of integer;
a,b,c,n,m,i:integer;
procedure swap(var a,b:integer);
var
t:integer;
begin
  t:=a;
  a:=b;
  b:=t;
 end;
begin
readln(a);
for i:= 1 to a do read(t[i]);
read(c);
for i:= 1 to a-1 do
 for b:= a downto 2 do
  begin
   if t[b]>=t[b-1] then swap(t[b],t[b-1]);
  end;
  i:=0;
repeat
i:=i+1;
until t[i]=c;
writeln(i);
end.

