package org.stella;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.stella.typecheck.VisitTypeCheck;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class MainTest {


    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @ValueSource(strings = {
            "tests/universal-types/well-typed/universal-types-1.stella",
            "tests/universal-types/well-typed/universal-types-2.stella",
            "tests/universal-types/well-typed/universal-types-3.stella",
            "tests/universal-types/well-typed/universal-types-4.stella",
            "tests/universal-types/well-typed/universal-types-5.stella",
            "tests/universal-types/well-typed/universal-types-6.stella",

            "tests/subtyping/well-typed/subtyping-1.stella",
            "tests/subtyping/well-typed/subtyping-2.stella",
            "tests/subtyping/well-typed/subtyping-3.stella",
            "tests/subtyping/well-typed/subtyping-4.stella",
//            "tests/subtyping/well-typed/subtyping-5.stella", // TODO CAST if I'll have time
            "tests/subtyping/well-typed/subtyping-6.stella",
//            "tests/subtyping/well-typed/subtyping-7.stella", // TODO BOT if I'll have time
//            "tests/subtyping/well-typed/subtyping-8.stella", // TODO TOP if I'll have time
            "tests/references/well-typed/refs-1.stella",
            "tests/references/well-typed/refs-2.stella",
//            "tests/references/well-typed/refs-3.stella", // TODO LET if I'll have time
            "tests/references/well-typed/refs-4.stella",
//            "tests/exceptions/well-typed/panic-1.stella", // TODO LET if I'll have time
            "tests/exceptions/well-typed/panic-2.stella",
            "tests/exceptions/well-typed/panic-3.stella",
            "tests/exceptions/well-typed/panic-4.stella",
            "tests/records/well-typed/records-1.stella",

            "tests/sum-types/well-typed/sum-types-1.stella",
            "tests/sum-types/well-typed/sum-types-2.stella",
            "tests/tuples/well-typed/tuples-1.stella",
            "tests/unit/unit1.stella",
            "tests/pairs/well-typed/pairs-1.stella",

            "tests/core/well-typed/abstract-function.stella",
            "tests/core/well-typed/added-test-1.stella",
            "tests/core/well-typed/added-test-2.stella",
            "tests/core/well-typed/apply-increase.stella",
            "tests/core/well-typed/applying-actual-function-3.stella",
            "tests/core/well-typed/bool-to-nat.stella",
            "tests/core/well-typed/cubes.stella",
            "tests/core/well-typed/double-application.stella",
            "tests/core/well-typed/factorial.stella",
            "tests/core/well-typed/good-if.stella",
            "tests/core/well-typed/good-if-2.stella",
            "tests/core/well-typed/good-succ-1.stella",
            "tests/core/well-typed/good-succ-2.stella",
            "tests/core/well-typed/higher-order-1.stella",
            "tests/core/well-typed/higher-order-2.stella",
            "tests/core/well-typed/increment-triple.stella",
            "tests/core/well-typed/increment_twice.stella",
            "tests/core/well-typed/inner-if.stella",
            "tests/core/well-typed/logical-operators.stella",
            "tests/core/well-typed/many-if.stella",
            "tests/core/well-typed/my-good-if.stella",
            "tests/core/well-typed/my-good-succ.stella",
            "tests/core/well-typed/my-well-typed-1.stella",
            "tests/core/well-typed/my-well-typed-2.stella",
            "tests/core/well-typed/nat-to-bool.stella",
            "tests/core/well-typed/negate.stella",
            "tests/core/well-typed/nested.stella",
            "tests/core/well-typed/shadowed-variable-2.stella",
            "tests/core/well-typed/simple-succ.stella",
            "tests/core/well-typed/simple-types.stella",
            "tests/core/well-typed/squares.stella",
            "tests/core/well-typed/succ-with-func.stella",
            "tests/core/well-typed/x-simple-if.stella",
    })
    public void testWellTyped(String filepath) throws IOException, Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(filepath));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @ValueSource(strings = {
//            "tests/core/well-typed/app.stella", // TODO DEL
//            "tests/universal-types/well-typed/universal-types-4.stella", // TODO DEL
//            "tests/universal-types/ill-typed/bad-universal-types-2.stella", // TODO DEL

            "tests/universal-types/ill-typed/bad-universal-types-1.stella",
            "tests/universal-types/ill-typed/bad-universal-types-2.stella",
            "tests/universal-types/ill-typed/bad-universal-types-3.stella",
            "tests/universal-types/ill-typed/bad-universal-types-4.stella",
            "tests/universal-types/ill-typed/bad-universal-types-5.stella",
            "tests/universal-types/ill-typed/bad-universal-types-6.stella",

            "tests/subtyping/ill-typed/bad-subtyping-1.stella",
            "tests/subtyping/ill-typed/bad-subtyping-2.stella",
//            "tests/subtyping/ill-typed/bad-subtyping-3.stella", // WRONG TEST
            "tests/subtyping/ill-typed/bad-subtyping-4.stella",
//            "tests/subtyping/ill-typed/bad-subtyping-5.stella", // TODO CAST if I'll have time
            "tests/references/ill-typed/bad-refs-1.stella",
            "tests/references/ill-typed/bad-refs-2.stella",
//            "tests/references/ill-typed/bad-refs-3.stella", // TODO LET if I'll have time
            "tests/exceptions/ill-typed/bad-panic-2.stella",
            "tests/exceptions/ill-typed/bad-panic-1.stella",
            "tests/records/ill-typed/bad-records-1.stella",

            "tests/sum-types/ill-typed/bad-sum-types-1.stella",
            "tests/tuples/ill-typed/bad-tuples-1.stella",
            "tests/unit/bad_unit1.stella",
            "tests/pairs/ill-typed/bad-pairs-1.stella",

            "tests/core/ill-typed/added-test-1.stella",
            "tests/core/ill-typed/added-test-2.stella",
            "tests/core/ill-typed/application-param-type.stella",
            "tests/core/ill-typed/applying-non-function-1.stella",
            "tests/core/ill-typed/applying-non-function-2.stella",
            "tests/core/ill-typed/applying-non-function-3.stella",
            "tests/core/ill-typed/argument-type-mismatch-1.stella",
            "tests/core/ill-typed/argument-type-mismatch-2.stella",
            "tests/core/ill-typed/argument-type-mismatch-3.stella",
            "tests/core/ill-typed/bad-abstraction.stella",
            "tests/core/ill-typed/bad-factorial.stella",
            "tests/core/ill-typed/bad-factorial-1.stella",
            "tests/core/ill-typed/bad-factorial-2.stella",
            "tests/core/ill-typed/bad-function-call.stella",
            "tests/core/ill-typed/bad-higher-order-1.stella",
            "tests/core/ill-typed/bad-if-1.stella",
            "tests/core/ill-typed/bad-if-2.stella",
            "tests/core/ill-typed/bad-if-3.stella",
            "tests/core/ill-typed/bad-if-4.stella",
            "tests/core/ill-typed/bad-if-and-undefined-variable-1.stella",
            "tests/core/ill-typed/bad-iszero.stella",
            "tests/core/ill-typed/bad-logic-not-1.stella",
            "tests/core/ill-typed/bad-nat-1.stella",
            "tests/core/ill-typed/bad-nat-2.stella",
            "tests/core/ill-typed/bad-nat-rec-1.stella",
            "tests/core/ill-typed/bad-nat-rec-2.stella",
            "tests/core/ill-typed/bad-return-type.stella",
            "tests/core/ill-typed/bad-squares-1.stella",
            "tests/core/ill-typed/bad-squares-2.stella",
            "tests/core/ill-typed/bad-succ-1.stella",
            "tests/core/ill-typed/bad-succ-2.stella",
            "tests/core/ill-typed/bad-succ-3.stella",
            "tests/core/ill-typed/function-mismatch.stella",
            "tests/core/ill-typed/invalid-nat.stella",
            "tests/core/ill-typed/invalid-not_.stella",
            "tests/core/ill-typed/my-factorial.stella",
            "tests/core/ill-typed/my-ill-test-2.stella",
            "tests/core/ill-typed/my-ill-typed-1.stella",
            "tests/core/ill-typed/my-ill-typed-2.stella",
            "tests/core/ill-typed/my-mismatch.stella",
            "tests/core/ill-typed/nat__rec-parameters.stella",
            "tests/core/ill-typed/shadowed-variable-1.stella",
            "tests/core/ill-typed/shadowed-variable-2.stella",
            "tests/core/ill-typed/undefined-variable-1.stella",
            "tests/core/ill-typed/undefined-variable-2.stella",
            "tests/core/ill-typed/undefined-variable-3.stella",
            })
    public void testIllTyped(String filepath) throws IOException, Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(filepath));
        System.setIn(fips);

        boolean typecheckerFailed = false;
        try {
            Main.main(args); // TODO: check that if it fail then there is a type error actually, and not a problem with implementation
        } catch (VisitTypeCheck.TypeError e) {
            System.out.println("Type Error: " + e.getMessage());
            typecheckerFailed = true;
        }
        if (!typecheckerFailed) {
            throw new Exception("expected the typechecker to fail!");
        }
        // System.setIn(original); // dead code
    }
}
