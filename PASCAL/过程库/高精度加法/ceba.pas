var
a,b:string;
function sum(a,b:string):string;
var
s1,s2:string;
la,lb:integer;
w,e,r:array[1..500]of integer;
m,i,x:integer;
begin
readln(s1);
la:=length(s1);
for i:= 1 to la do w[i]:=ord(s1[i])-48;
readln(s2);
lb:=length(s2);
for i:= 1 to lb do e[i]:=ord(s2[i])-48;
i:=0;
while (i<=la) or (i<=lb) do
begin
  i:=i+1;
  r[i]:=(x+w[i]+e[i]) mod 10;
  x:=(w[i]+e[i]+x) div 10;
end;
if x<10 then i:=i-1;
for m:= i downto 1 do sum[m]:=r[m];
end;
begin
readln(a,b);
writeln(sun(a,b));
end.
