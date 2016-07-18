var
 a:array[1..100] of integer;
 i,j,k,n,temp,q:integer;
 g:boolean;
begin
  n:=0;
  while not eoln do
  begin
    inc(n);
    read(a[n]);
  end;
  readln(temp);
  g:=false;
  for i:=1 to n do
  begin
        if a[i]=temp then
        begin
          for j:= i to n-1 do
             a[j]:=a[j+1];
          g:=true;
          q:=i;
          break;
        end
        else if a[i]>temp then
        begin
          for k:=n+1 downto i do
             a[k]:=a[k-1];
             a[i]:=temp;
             q:=i;
             g:=false;
             break;
        end;
  end;
  if g then
  begin
     writeln(q);
     for j:=1 to n-1 do
      write(a[j],' ');
  end
  else
   begin
     writeln(q);
     for j:= 1 to n+1 do
      write(a[j],' ');
  end;
  writeln;
end.