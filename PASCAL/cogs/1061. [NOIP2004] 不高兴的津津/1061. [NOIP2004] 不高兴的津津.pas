var
a,b,n,m,i:integer;
t:boolean;
begin
assign(input,'unhappy.in');
assign(output,'unhappy.out');
reset(input);
rewrite(output);
for i:= 1 to 7 do
 begin
  readln(a,b);
  if ((a+b)>m) then
   begin
    t:=false;
    m:=a+b;
    n:=i;
   end;
 end;
if t then writeln('0') else writeln(n);
close(input);
close(output);
end.

