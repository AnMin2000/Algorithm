-- 코드를 입력하세요
SELECT A.PRODUCT_ID, PRODUCT_NAME, SUM(PRICE * AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A JOIN FOOD_ORDER B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE PRODUCE_DATE >= '2022-05-01' AND PRODUCE_DATE < '2022-06-01'
GROUP BY B.PRODUCT_ID
ORDER BY 3 DESC, 1