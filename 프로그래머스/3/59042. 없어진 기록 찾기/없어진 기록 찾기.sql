-- 코드를 입력하세요 들어온 기록 X + 나간 기록 O
SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS A
WHERE NOT EXISTS(SELECT 1 FROM ANIMAL_INS B WHERE A.ANIMAL_ID = B.ANIMAL_ID)