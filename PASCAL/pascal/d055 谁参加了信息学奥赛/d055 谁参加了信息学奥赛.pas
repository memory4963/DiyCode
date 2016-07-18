var a,b,c,d,e:integer;
begin
  for a:= 0 to 1 do
    for b:= 0 to 1 do
      for c:= 0 to 1 do
        for d:= 0 to 1 do
          for e:= 0 to 1 do
          if ((a=1) and (b=1)) or (a=0) then
            if b + c = 1 then
              if ((c=1) and (d=1)) or ((c=0) and (d=0)) then
                if ((d=1) and (e=0)) or ((d=0) and (e=1)) or ((d=1) and (e=1)) then
                  if ((e=1) and (a=1) and (d=1)) or (e=0) then
                    begin
                      if a=1 then write('A');
                      if b=1 then write('B');
                      if c=1 then write('C');
                      if d=1 then write('D');
                      if e=1 then write('E');
                    end;
 end. 