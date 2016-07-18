var
tree,l,m,n,i,a,b:integer;
t:array[0..10000]of boolean;
begin
assign(input,'tsuri.in');
assign(output,'tsuri.out');
reset(input);
rewrite(output);
readln(l,m);
tree:=0;
fillchar(t,sizeof(t),false);
for i:= 0 to l do t[i]:=true;
for i:= 1 to m do
 begin
  readln(a,b);
  for n:= a to b do t[n]:=false;
 end;
for i:= 0 to l do if t[i] then tree:=tree+1;
writeln(tree);
close(input);
close(output);
end.
