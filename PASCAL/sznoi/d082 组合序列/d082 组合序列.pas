var
a,b,c,n,m,i,k,p:integer;
function jiecheng(n:integer):longint;
var
a:int64;
n,i:integer;
begin
readln(n);
a:=1;
for i:= 2 to n do
 a:=a*i;
jiecheng:=a;;
end;
begin
readln(n,m);
writ
