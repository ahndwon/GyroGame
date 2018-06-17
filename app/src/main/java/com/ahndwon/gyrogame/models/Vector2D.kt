package models

class Vector2D : Cloneable {

    /**
     * @return x value of Vector2D.
     */
    /**
     * replace Vector2D's x value with a parameter.
     * @param x parameter for changing Vector2D's x value.
     */
    var x: Float = 0.toFloat()
    /**
     * @return y value of Vector2D.
     */
    /**
     * replace Vector2D's y value with a parameter.
     * @param y parameter for changing Vector2D's y value.
     */
    var y: Float = 0.toFloat()

    var vector2D: Vector2D
        get() = this
        set(vector2D) = setVector2D(vector2D.x, vector2D.y)

    /**
     * Hello. JavaDoc...
     */


    constructor() {}


    fun setVector2D(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    /**
     * constructor with two parameters -x and y-.
     * @param x parameter for setting Vector2D's x value.
     * @param y parameter for setting Vector2D's y value.
     */
    constructor(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    /**
     * constructor with a parameter -Vector2D-.
     * @param vector2D parameter for setting Vector2D.
     */
    constructor(vector2D: Vector2D) {
        this.x = vector2D.x
        this.y = vector2D.y
    }


    /**
     * get sign of a value.
     * @param value parameter for getting sign.
     * @return a sign of a value.
     */
    fun getSign(value: Int): Int {
        return if (value < 0)
            -1
        else if (value == 0)
            0
        else
            1
    }

    /**
     * change Vector2D with two parameters -x and y-. (Add)
     * @param x parameter for adding Vector2D's x value.
     * @param y parameter for adding Vector2D's y value.
     */
    fun add(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    /**
     * change Vector2D with a parameter -Vector2D-.
     * @param vector2D parameter for adding Vector2D.
     */
    fun add(vector2D: Vector2D) {
        this.add(vector2D.x, vector2D.y)
    }

    /**
     * change Vector2D with two parameters -x and y-. (Subtract)
     * @param x        parameter for subtracting Vector2D's x value.
     * @param y        parameter for subtracting Vector2D's y value.
     */
    fun subtract(x: Float, y: Float) {
        this.x -= x
        this.y -= y
    }

    /**
     * change Vector2D with a parameter -Vector2D-
     * @param vector2D parameter for subtracting Vector2D.
     */
    fun subtract(vector2D: Vector2D) {
        this.subtract(vector2D.x, vector2D.y)
    }

    /**
     * change Vector2D with two parameters -x and y-. (Add)
     * @param x parameter for multiplying Vector2D's x value.
     * @param y parameter for multiplying Vector2D's y value.
     */
    fun multiply(x: Float, y: Float) {
        this.x *= x
        this.y *= y
    }

    /**
     * change Vector2D with a parameter -Vector2D-.
     * @param vector2D parameter for multiplying Vector2D.
     */
    fun multiply(vector2D: Vector2D) {
        this.multiply(vector2D.x, vector2D.y)
    }

    /**
     * changes the x-value of Vector2D symmetrically. (standard: line X = x)
     * @param x parameter which will be used as a standard for changing x-value of Vector2D.
     */
    fun reflectX(x: Float) {
        this.x = 2 * x - this.x
    }

    /**
     * changes the y-value of Vector2D symmetrically. (standard: line Y = y)
     * @param y parameter which will be used as a standard for changing y-value of Vector2D.
     */
    fun reflectY(y: Float) {
        this.y = 2 * y - this.y
    }

    /**
     * changes two values -x and y- of Vector2D symmetrically. (standard: Point (x, y))
     * @param x parameter which will be used as a standard for changing x-value of Vector2D.
     * @param y parameter which will be used as a standard for changing y-value of Vector2D.
     */
    fun reflect(x: Float, y: Float) {
        reflectX(x)
        reflectY(y)
    }

    /**
     * changes two values -x and y- of Vector2D symmetrically. (standard: Vector2D)
     * @param vector2D parameter which will be used as a standard for changing Vector2D.
     */
    fun reflect(vector2D: Vector2D) {
        reflect(vector2D.x, vector2D.y)
    }

    /**
     * changes the sign of value x.
     */
    fun reverseX() {
        this.x *= -1f
    }

    /**
     * changes the sign of value y.
     */
    fun reverseY() {
        this.y *= -1f
    }

    /**
     * changes the sign of value x and y.
     */
    fun reverseAll() {
        reverseX()
        reverseY()
    }


    fun distance(x: Float, y: Float): Float {
        return Math.sqrt(((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)).toDouble()).toFloat()
    }

    /**
     * returns the distance from Vector2D(0, 0) to itself.
     * @return the distance from Vector2D(0, 0) to itself.
     */
    fun magnitude(): Float {
        return getDistance(this, Vector2D(0f, 0f))
    }

    /**
     * normalizes x value.
     */
    fun normalizeX() {
        this.x /= this.magnitude()
    }

    /**
     * normalizes y value.
     */
    fun normalizeY() {
        this.y /= this.magnitude()
    }

    /**
     * normalizes two values -x and y-.
     */
    fun normalize() {
        normalizeX()
        normalizeY()
    }

    /**
     * rotates Vector2D based on a Vector2D(base) to the extent of (angle).
     * @param angle parameter for rotating.
     * @param base  parameter for rotating.
     */
    fun rotate(angle: Float, base: Vector2D) {

        val tmpVector = this.clone()
        tmpVector!!.subtract(base)
        tmpVector.x = (Math.cos(angle.toDouble()) * x - Math.sin(angle.toDouble()) * y).toFloat()
        tmpVector.y = (Math.sin(angle.toDouble()) * x + Math.cos(angle.toDouble()) * y).toFloat()
        tmpVector.add(base)
        vector2D = tmpVector
    }

    /**
     * rotates Vector2D based on a Vector2D(0, 0) to the extent of (angle).
     * @param angle parameter for rotating.
     */
    fun rotateFromOrigin(angle: Float) {
        rotate(angle, Vector2D(0f, 0f))
    }

    /**
     * clones Vector2D
     * @return cloned Vector2D object.
     */
    public override fun clone(): Vector2D {
        return super.clone() as Vector2D
    }


    /**
     * prints Vector 2D states
     */
    fun print() {
        print("X: " + x + "Y:" + y)
    }

    /**
     * prints Vector 2D states
     */
    fun println() {
        println("X: " + x + "Y:" + y)
    }

    companion object {


        /**
         *
         * @param vector2D
         * @return
         */
        fun getSigned(vector2D: Vector2D): Vector2D {
            val x: Int
            val y: Int
            x = vector2D.getSign(vector2D.x.toInt())
            y = vector2D.getSign(vector2D.y.toInt())
            return Vector2D(vector2D.x * x, vector2D.y * y)
        }

        /**
         * returns new Vector2D after add with three parameters -Vector2D, x and y-.
         * @param vector2D parameter for adding.
         * @param x        parameter for adding.
         * @param y        parameter for adding.
         * @return new Vector2D after add.
         */
        fun getAdded(vector2D: Vector2D, x: Float, y: Float): Vector2D {
            val added = vector2D.clone()
            added!!.add(x, y)
            return added
        }

        /**
         * returns new Vector2D after add with two parameters -two Vector2D objects-.
         * @param v1       parameter for adding.
         * @param v2       parameter for adding.
         * @return new Vector2D after add.
         */
        fun getAdded(v1: Vector2D, v2: Vector2D): Vector2D {
            val added = v1.clone()
            added!!.add(v2)
            return added
        }

        /**
         * returns new Vector2D after subtraction with three parameters -Vector2D, x and y-.
         * @param vector2D parameter for subtracting.
         * @param x        parameter for subtracting.
         * @param y        parameter for subtracting.
         * @return new Vector2D after subtraction.
         */
        fun getSubtracted(vector2D: Vector2D, x: Float, y: Float): Vector2D {
            val subtracted = vector2D.clone()
            subtracted!!.subtract(x, y)
            return subtracted
        }

        /**
         * returns new Vector2D after subtraction with two parameters -two Vector2D objects-.
         * @param v1 parameter for subtracting.
         * @param v2 parameter for subtracting.
         * @return new Vector2D after subtraction.
         */
        fun getSubtracted(v1: Vector2D, v2: Vector2D): Vector2D? {
            val subtracted = v1.clone()
            v1.subtract(v2)
            return subtracted
        }

        /**
         * returns new Vector2D after multiplication with three parameters -Vector2D, x and y-.
         * @param vector2D parameter for multiplying.
         * @param x        parameter for multiplying.
         * @param y        parameter for multiplying.
         * @return new Vector2D after multiplication.
         */
        fun getMultiplied(vector2D: Vector2D, x: Float, y: Float): Vector2D {
            val multiplied = vector2D.clone()
            multiplied!!.multiply(x, y)
            return multiplied
        }

        /**
         * returns new Vector2D after multiplication with two parameters -two Vector2D objects-.
         * @param v1 parameter for multiplying.
         * @param v2 parameter for multiplying.
         * @return new Vector2D after multiplication.
         */
        fun getMultiplied(v1: Vector2D, v2: Vector2D): Vector2D? {
            val multiplied = v1.clone()
            v1.multiply(v2)
            return multiplied
        }

        /**
         * returns new Vector2D after reflection with three parameters -Vector2D, x and y-.
         * @param vector2D parameter which will be reflected.
         * @param x        parameter which will be used as a standard.
         * @param y        parameter which will be used as a standard.
         * @return new Vector2D after reflection.
         */
        fun getReflected(vector2D: Vector2D, x: Float, y: Float): Vector2D {
            val reflected = vector2D.clone()
            reflected!!.reflect(x, y)
            return reflected
        }

        /**
         * returns new Vector2D after reflection with two parameters -two Vector2D objects-.
         * @param vector2D parameter which will be reflected.
         * @param base     parameter which will be used as a standard.
         * @return new Vector2D after reflection.
         */
        fun getReflected(vector2D: Vector2D, base: Vector2D): Vector2D {
            val reflected = vector2D.clone()
            reflected!!.reflect(base)
            return reflected
        }

        /**
         * returns the distance of two Vector2Ds with two parameters -two Vector2D objects-.
         * @param v1 parameter for getting distance.
         * @param v2 parameter for getting distance.
         * @return the distance of two Vector2Ds.
         */
        fun getDistance(v1: Vector2D, v2: Vector2D): Float {
            return Math.sqrt(Math.pow((v1.x - v2.x).toDouble(), 2.0) + Math.pow((v1.y - v2.y).toDouble(), 2.0)).toFloat()
        }

        /**
         * returns the distance of two Vector2Ds with four parameters -two x values and two y values-.
         * @param x1 parameter for getting distance.
         * @param x2 parameter for getting distance.
         * @param y1 parameter for getting distance.
         * @param y2 parameter for getting distance.
         * @return the distance of two Vector2Ds.
         */
        fun getDistance(x1: Float, y1: Float, x2: Float, y2: Float): Float {
            return Math.sqrt(Math.pow((x1 - x2).toDouble(), 2.0) + Math.pow((y1 - y2).toDouble(), 2.0)).toFloat()
        }

        /**
         * returns the distance from Vector2D(0, 0) to a vector2D.
         * @param vector2D parameter for getting distance.
         * @return the distance from Vector2D(0, 0) to a vector2D.
         */
        fun magnitude(vector2D: Vector2D): Float {
            return getDistance(vector2D, Vector2D(0f, 0f))
        }

        /**
         * returns the distance from Vector2D(0, 0) to a Vector2D(0, 0).
         * @param x parameter for getting distance.
         * @param y parameter for getting distance.
         * @return the distance from Vector2D(0, 0) to a Vector2D(0, 0).
         */
        fun magnitude(x: Float, y: Float): Float {
            return getDistance(x, y, 0f, 0f)
        }

        /**
         * returns new Vector2D after normalization.
         * @param vector2D parameter for normalizing.
         * @return new Vector2D after normalization.
         */
        fun getNormalized(vector2D: Vector2D): Vector2D {
            val normalized = vector2D.clone()
            normalized!!.normalize()
            return normalized
        }

        /**
         * returns new Vector2D after rotation with three parameters -Vector2D, angle, and Vector2D(base)-.
         * @param vector2D parameter which will be rotated.
         * @param angle    parameter used as the extent for rotating.
         * @param base     parameter which will be used as a standard.
         * @return new Vector2D after rotation.
         */
        fun getRotated(vector2D: Vector2D, angle: Float, base: Vector2D): Vector2D {
            val rotated = getSubtracted(vector2D, base)!!.clone()
            rotated!!.rotate(angle, base)
            return rotated
        }

        /**
         * returns new Vector2D after rotation with two parameters -Vector2D, angle- based on a Vector2D(0, 0).
         * @param vector2D parameter which will be rotated.
         * @param angle    parameter used as the extent for rotating.
         * @return new Vector2D after rotation.
         */
        fun getRotatedFromOrigin(vector2D: Vector2D, angle: Float): Vector2D {
            val rotated = vector2D.clone()
            rotated!!.rotateFromOrigin(angle)
            return rotated
        }
    }
}