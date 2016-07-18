var
a,b,c,d,e,f,n,i,m:integer;
begin
readln(n);
for i:= 1 to n do
 begin
  readln(m);
  if m=100 then a:=a+1
   else if (m>89) and (m<100) then b:=b+1
    else if (m>79) and (m<90) then c:=c+1
     else if (m>69) and (m<80) then d:=d+1
      else if (m>59) and (m<70) then e:=e+1
       else if (m<60) then f:=f+1;
  end;
writeln(a);
writeln(b);
writeln(c);
writeln(d);
writeln(e);
writeln(f);
end.
