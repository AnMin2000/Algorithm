-- 코드를 작성해주세요
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, ((SELECT MAX(SIZE_OF_COLONY) 
                                            FROM ECOLI_DATA B
                                            WHERE YEAR(A.DIFFERENTIATION_DATE) = YEAR(B.DIFFERENTIATION_DATE)) - SIZE_OF_COLONY) AS YEAR_DEV, ID
FROM ECOLI_DATA A
ORDER BY 1, 2