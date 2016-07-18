var
  l,r,i:integer;
  m:longint;
begin
   assign(input,'twoj.in');
   assign(output,'twoj.out');
   reset(input);
   rewrite(output);
   readln(l,r);
  for i:= l to r do
   begin
   if (i>=0) and (i<10)  then
     begin
      if i=2 then m:=m+1;
     end
    else if (i>=10) and (i<100)  then
    begin
     if i mod 10 =2 then m:=m+1;
     if i div 10 =2 then m:=m+1;
    end
     else if (i>=100) and (i<1000) then
     begin
      if (i mod 10)=2 then m:=m+1;
      if (i div 100)=2 then m:=m+1;
      if (((i mod 100) -(i mod 10)) div 10)=2 then m:=m+1;
     end
      else if (i>=1000) and (i<10000) then
      begin
if (i div 1000)=2 then m:=m+1;
if (i div 100)-10*(i div 1000)=2 then m:= m+1;
if (((i mod 100)-(i mod 10))/10)=2 then m:=m+1;
if (i mod 10) =2 then m:= m+1;
      end;
   end;
writeln(m);
close(input);
close(output);
end.
