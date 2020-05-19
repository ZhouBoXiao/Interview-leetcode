select w1.id
from weather as w1
left join weather as w2
on datediff(w1.RecordDate, w2.RecordDate) = 1
where w2.RecordDate is not null and w1.Temperature > w2.Temperature


