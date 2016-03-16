# URLShorty
CLX network interview question.

Review
- Plus grande séparation des responsabilités entre les composants ainsi que plus d’interfaces d'abstractions (Single Responsibility Principle et Dependency Inversion Principle)
- L’algorithme utilisé pour générer les clés fonctionne, mais il ne génère que des clés ayant n % 5 caractères (modulo) ce qui limite grandement le nombre de clés possibles, et cela peut aussi générer dans de rares cas des clés ayant plus de 10 caractères
- Les tests sont vides.
