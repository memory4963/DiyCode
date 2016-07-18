var i,j,k:integer;
    a:array[1..100]of boolean;
begin
fillchar(a,sizeof(a),true);
   for i:=2 to 100 do begin
      if(a[i])then begin
        j:=2;
        while(i*j)<=100 do begin
           a[i*j]:=false;
           inc(j);
        end;
      end;
    end;
   for i:=2  to 100  do
      if(a[i])then
         writeln(i);
end.
