var
a,b,c,i,n,m,k:integer;
w:char;
begin
readln(w);
c:=1;
a:=ord(w)-65;
b:=ord(w)-64;
k:=0;
for i:= 1 to b do
 begin
  for n:= 1 to a do
   begin
    write(' ');
   end;
  a:=a-1;
  for m:= 1 to c do
   begin
    write(chr(65+k));
   end;
  c:=c+2;
  k:=k+1;
  writeln;
 end;
begin
c:=c-4;
a:=1;
b:=ord(w)-64;
k:=ord(w)-1;
end;
for i:= b downto 1 do
 begin
  begin
  for n:= 1 to a do write(' ');
  a:=a+1;
  end;
  for m:= c downto 1 do
    begin
     write(chr(k));
    end;
    c:=c-2;
    k:=k-1;
    writeln;
 end;
end.
