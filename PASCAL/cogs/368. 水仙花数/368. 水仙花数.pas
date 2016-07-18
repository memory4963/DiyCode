var
a,b,c,x:integer;
function three(i,m,n:integer):integer;
begin
three:=a*a*a+b*b*b+c*c*c;
end;
begin
assign(input,'daff.in');
assign(output,'daff.out');
reset(input);
rewrite(output);
readln(x);
a:=x div 100;
c:=x mod 10;
b:=((x mod 100)-c)div 10;
if three(a,b,c)=x then writeln('TRUE')
 else writeln('FALSE');
close(input);
close(output);
end.
