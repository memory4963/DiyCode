var
a,n,i:longint;
w:array[1..1000]of integer;
begin
readln(a);
n:=0;
i:=0;
repeat
n:=n+1;
i:=i+1;
w[i]:=a mod 2;
a:=a div 2;
until a=0;
for i:= n downto 1 do write(w[i]);
end.
